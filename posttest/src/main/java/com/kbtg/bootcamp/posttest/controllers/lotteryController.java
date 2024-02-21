package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.dto.response.LotteryResponseDto;
import com.kbtg.bootcamp.posttest.services.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lotteries")
public class lotteryController {

    @Autowired
    private LotteryService lotteryService;
    @GetMapping
    public List<LotteryResponseDto> getAll() {
        
        return lotteryService.getLottery();
    }
}
