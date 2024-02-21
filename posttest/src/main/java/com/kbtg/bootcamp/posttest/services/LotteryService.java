package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.dto.response.LotteryResponseDto;
import com.kbtg.bootcamp.posttest.repositories.LotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LotteryService {

    @Autowired
    private LotteryRepository lotteryRepository;

    public List<LotteryResponseDto> getLottery(){
        List<LotteryResponseDto> responseDtos = new ArrayList<>();


        return responseDtos;
    }
}
