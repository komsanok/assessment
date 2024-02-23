package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.dto.response.UserBuyLotteryReponseDto;
import com.kbtg.bootcamp.posttest.dto.response.UserDeleteTicketResponseDto;
import com.kbtg.bootcamp.posttest.dto.response.UserTicketAllReponseDto;
import com.kbtg.bootcamp.posttest.services.UserService;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    UserService userService;

    @PostMapping("/{userId}/lotteries/{ticketId}")
    public UserBuyLotteryReponseDto BuyLottery(@PathVariable("userId") @NotBlank(message  = "userId is not null") @Size(min = 10, max = 10, message = "userId length equal to 6") String userId,
                                               @PathVariable("ticketId") @Size(min = 6,max = 6, message = "ticket length equal to 6") @Pattern(regexp = "^\\d{6}$", message = "ticket input numbers") @NotNull(message = "ticket is not null") String ticketId) {

        return userService.BuyLottery(userId, ticketId);
    }

    @GetMapping("/{userId}/lotteries")
    public UserTicketAllReponseDto GetLotteryByUserId(@PathVariable("userId") @NotBlank(message  = "userId is not null") @Size(min = 10, max = 10, message = "userId length equal to 6") String userId) {
        return userService.GetLotteryByUserId(userId);
    }

    @DeleteMapping("/{userId}/lotteries/{ticketId}")
    public UserDeleteTicketResponseDto DeleteLottery(@PathVariable("userId") @NotBlank(message  = "userId is not null") @Size(min = 10, max = 10, message = "userId length equal to 6") String userId,
                                                     @PathVariable("ticketId")  @Size(min = 6,max = 6, message = "ticket length equal to 6") @Pattern(regexp = "^\\d{6}$", message = "ticket input numbers") @NotNull(message = "ticket is not null")  String ticketId) {
        return userService.DeleteLottery(userId, ticketId);
    }
}

