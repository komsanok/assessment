package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.dto.response.UserBuyLotteryReponseDto;
import com.kbtg.bootcamp.posttest.dto.response.UserTicketAllReponseDto;
import com.kbtg.bootcamp.posttest.entities.Lottery;
import com.kbtg.bootcamp.posttest.entities.UserTicket;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import com.kbtg.bootcamp.posttest.repositories.LotteryRepository;
import com.kbtg.bootcamp.posttest.repositories.UserTicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private LotteryRepository lotteryRepository;
    @Autowired
    private UserTicketRepository userTicketRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserBuyLotteryReponseDto BuyLottery(String userId, String ticketId) {
        UserBuyLotteryReponseDto userBuyLotteryReponseDto = new UserBuyLotteryReponseDto();
        List<Lottery> lotteries = lotteryRepository.findByLotteryId(ticketId);
        if (lotteries.isEmpty()) {
            throw new NotFoundException(String.format("not found ticket : %s", ticketId));
        } else {
            UserTicket userTicket = new UserTicket();
            userTicket.setLottery(lotteries.get(0));
            userTicket.setUserId(userId);
            userTicketRepository.save(userTicket);

            userBuyLotteryReponseDto = modelMapper.map(userTicket, UserBuyLotteryReponseDto.class);
        }

        return userBuyLotteryReponseDto;
    }

    public UserTicketAllReponseDto GetLotteryByUserId(String userId) {
        UserTicketAllReponseDto userTicketAllReponseDto = new UserTicketAllReponseDto();
        List<UserTicket> userTicketList = userTicketRepository.findAll().stream().filter(r -> r.getUserId().equals(userId)).collect(Collectors.toList());
        if (userTicketList.isEmpty()) {
            throw new NotFoundException(String.format("not found user id : %s", userId));
        } else {

            Long countLottery = userTicketList.stream().mapToInt(r -> r.getLottery().getAmount()).count();
            Double sumLottery = userTicketList.stream().mapToDouble(r -> r.getLottery().getPrice()).sum();
            List<String> listLottery = userTicketList.stream().map(r -> r.getLottery().getTicket()).collect(Collectors.toList());
            userTicketAllReponseDto.setTicket(listLottery);
            userTicketAllReponseDto.setCount(countLottery);
            userTicketAllReponseDto.setCost(sumLottery);
        }
        return userTicketAllReponseDto;
    }

}
