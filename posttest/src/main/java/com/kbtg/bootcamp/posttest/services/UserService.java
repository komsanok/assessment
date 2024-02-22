package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.dto.response.UserBuyLotteryReponseDto;
import com.kbtg.bootcamp.posttest.entities.Lottery;
import com.kbtg.bootcamp.posttest.entities.UserTicket;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import com.kbtg.bootcamp.posttest.repositories.LotteryRepository;
import com.kbtg.bootcamp.posttest.repositories.UserTicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
