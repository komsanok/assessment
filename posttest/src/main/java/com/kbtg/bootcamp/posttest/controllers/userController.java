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
    public UserBuyLotteryReponseDto BuyLottery(@PathVariable("userId") @NotNull(message  = "userId is not null") @Size(min = 10, max = 10, message = "userId length equal to 10") @Pattern(regexp = "^\\d{10}$", message = "userId input numbers") String userId,
                                               @PathVariable("ticketId") @NotNull(message  = "ticket is not null") @Size(min = 6,max = 6, message = "ticket length equal to 6") @Pattern(regexp = "^\\d{6}$", message = "ticket input numbers")  String ticketId) {

        return userService.BuyLottery(userId, ticketId);
    }

    @GetMapping("/{userId}/lotteries")
    public UserTicketAllReponseDto GetLotteryByUserId(@PathVariable("userId") @NotNull(message  = "userId is not null") @Size(min = 10, max = 10, message = "userId length equal to 10") @Pattern(regexp = "^\\d{10}$", message = "userId input numbers")  String userId) {
        return userService.GetLotteryByUserId(userId);
    }

    @DeleteMapping("/{userId}/lotteries/{ticketId}")
    public UserDeleteTicketResponseDto DeleteLottery(@PathVariable("userId") @NotNull(message  = "userId is not null") @Size(min = 10, max = 10, message = "userId length equal to 10") @Pattern(regexp = "^\\d{10}$", message = "userId input numbers") String userId,
                                                     @PathVariable("ticketId") @NotNull(message  = "ticket is not null") @Size(min = 6,max = 6, message = "ticket length equal to 6") @Pattern(regexp = "^\\d{6}$", message = "ticket input numbers")  String ticketId) {
        return userService.DeleteLottery(userId, ticketId);
    }
}

