package com.kbtg.bootcamp.posttest.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
public class adminController {

    @PostMapping("/lotteries")
    public void addLottery(){

    }
}
