package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.dto.response.LotteryAllResponseDto;
import com.kbtg.bootcamp.posttest.services.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lotteries")
public class lotteryController {

    @Autowired
    private LotteryService lotteryService;
    @GetMapping
    public LotteryAllResponseDto getAll() {
        return lotteryService.GetLottery();
    }

//    @PostMapping
//    public LotteryAddResponseDto AddLottery(@Valid  @RequestBody LotteryAddRequestDto lotteryAddRequestDto){
//
//       return  lotteryService.AddLottery(lotteryAddRequestDto);
//    }
}
