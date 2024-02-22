package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.dto.request.LotteryAddRequestDto;
import com.kbtg.bootcamp.posttest.dto.response.LotteryAddResponseDto;
import com.kbtg.bootcamp.posttest.services.LotteryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class adminController {
    @Autowired
    private LotteryService lotteryService;

    @PostMapping("/lotteries")
    public LotteryAddResponseDto AddLottery(@Valid @RequestBody LotteryAddRequestDto lotteryAddRequestDto){
        return  lotteryService.AddLottery(lotteryAddRequestDto);
    }
}
