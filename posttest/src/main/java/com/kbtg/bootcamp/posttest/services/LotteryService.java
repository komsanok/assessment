package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.dto.request.LotteryAddRequestDto;
import com.kbtg.bootcamp.posttest.dto.response.LotteryAddResponseDto;
import com.kbtg.bootcamp.posttest.dto.response.LotteryAllResponseDto;
import com.kbtg.bootcamp.posttest.entities.Lottery;
import com.kbtg.bootcamp.posttest.exception.DataDuplicateException;
import com.kbtg.bootcamp.posttest.repositories.LotteryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotteryService {

    @Autowired
    private LotteryRepository lotteryRepository;
    @Autowired
    private ModelMapper modelMapper;


    public LotteryAllResponseDto GetLottery() {
        LotteryAllResponseDto responseDtos = new LotteryAllResponseDto();
        List<Lottery> listAllLottery = lotteryRepository.findAll();
        List<String> listLottery= listAllLottery.stream().map(r -> r.getTicket()).collect(Collectors.toList());
        responseDtos.setTicket(listLottery);

        return responseDtos;
    }

    public LotteryAddResponseDto AddLottery(LotteryAddRequestDto lotteryAddRequestDto) {

        LotteryAddResponseDto lotteryAddResponseDto = new LotteryAddResponseDto();
        int countLottery = lotteryRepository.countByLotteryId(lotteryAddRequestDto.getTicket());
        if (countLottery == 0) {
            Lottery lotteryAdd = modelMapper.map(lotteryAddRequestDto, Lottery.class);
            lotteryRepository.save(lotteryAdd);
            lotteryAddResponseDto = modelMapper.map(lotteryAdd, LotteryAddResponseDto.class);

        } else {
            throw new DataDuplicateException(String.format("data duplicate lottery : %s", lotteryAddRequestDto.getTicket()));
        }

        return lotteryAddResponseDto;
    }
}
