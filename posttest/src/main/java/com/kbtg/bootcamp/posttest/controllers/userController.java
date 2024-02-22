package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.dto.response.UserBuyLotteryReponseDto;
import com.kbtg.bootcamp.posttest.dto.response.UserTicketAllReponseDto;
import com.kbtg.bootcamp.posttest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    UserService userService;

    @PostMapping("/{userId}/lotteries/{ticketId}")
    public UserBuyLotteryReponseDto BuyLottery(@PathVariable("userId") String userId, @PathVariable("") String ticketId) {

        return userService.BuyLottery(userId,ticketId);
    }

    @GetMapping("/{userId}/lotteries")
    public UserTicketAllReponseDto GetLotteryByUserId(@PathVariable("userId")String userId){
        return userService.GetLotteryByUserId(userId);
    }
}

