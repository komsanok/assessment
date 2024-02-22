package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.dto.response.UserBuyLotteryReponseDto;
import com.kbtg.bootcamp.posttest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    UserService userService;

    @PostMapping("/{userId}/lotteries/{ticketId}")
    public UserBuyLotteryReponseDto BuyLottery(@PathVariable("userId") String userId, @PathVariable("ticketId") String ticketId) {

        return userService.BuyLottery(userId,ticketId);
    }

    @GetMapping("/{userId}/lotteries")
    public void GetLotteryByUserId(@PathVariable("userId")String userId){
        userService.GetLotteryByUserId(userId);
        System.out.println(userId);
    }
}

