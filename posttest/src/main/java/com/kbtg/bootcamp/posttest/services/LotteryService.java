package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.dto.request.LotteryAddRequestDto;
import com.kbtg.bootcamp.posttest.dto.response.LotteryAddResponseDto;
import com.kbtg.bootcamp.posttest.repositories.LotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LotteryService {

    @Autowired
    private LotteryRepository lotteryRepository;

    public List<LotteryAddResponseDto> getLottery(){
        List<LotteryAddResponseDto> responseDtos = new ArrayList<>();


        return responseDtos;
    }

    public LotteryAddResponseDto AddLottery(LotteryAddRequestDto lotteryAddRequestDto){

        LotteryAddResponseDto lotteryAddResponseDto = new LotteryAddResponseDto();
        lotteryAddResponseDto.setTicket("654321");
        return lotteryAddResponseDto;
    }
}
