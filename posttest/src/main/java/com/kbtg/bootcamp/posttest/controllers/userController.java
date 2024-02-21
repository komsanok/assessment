package com.kbtg.bootcamp.posttest.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {
    @GetMapping
    public String getAllUser() {
        return "getAllUser";
    }

    @PostMapping("/{userId}/lotteries/{ticketId}")
    public void userBuyLottery(@PathVariable("userId") String userId, @PathVariable("ticketId") String ticketId) {

        System.out.println(userId);
    }

    @PostMapping("/{userId}/lotteries")
    public void getLotteryById(@PathVariable("userId")String userId){

    }
}

