package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.dto.request.LotteryAddRequestDto;
import com.kbtg.bootcamp.posttest.dto.response.LotteryAddResponseDto;
import com.kbtg.bootcamp.posttest.dto.response.LotteryAllResponseDto;
import com.kbtg.bootcamp.posttest.exception.DataDuplicateException;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import com.kbtg.bootcamp.posttest.services.LotteryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotteries")
public class lotteryController {

    @Autowired
    private LotteryService lotteryService;
    @GetMapping
    public LotteryAllResponseDto getAll() {
        return lotteryService.GetLottery();
    }

    @PostMapping
    public LotteryAddResponseDto AddLottery(@Valid  @RequestBody LotteryAddRequestDto lotteryAddRequestDto){

       return  lotteryService.AddLottery(lotteryAddRequestDto);
    }
}
