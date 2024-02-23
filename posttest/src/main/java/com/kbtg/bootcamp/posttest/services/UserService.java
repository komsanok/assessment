package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.dto.response.UserBuyLotteryReponseDto;
import com.kbtg.bootcamp.posttest.dto.response.UserDeleteTicketResponseDto;
import com.kbtg.bootcamp.posttest.dto.response.UserTicketAllReponseDto;
import com.kbtg.bootcamp.posttest.entities.Lottery;
import com.kbtg.bootcamp.posttest.entities.UserTicket;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import com.kbtg.bootcamp.posttest.repositories.LotteryRepository;
import com.kbtg.bootcamp.posttest.repositories.UserTicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private LotteryRepository lotteryRepository;
    @Autowired
    private UserTicketRepository userTicketRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public UserBuyLotteryReponseDto BuyLottery(String userId, String ticketId) {
        UserBuyLotteryReponseDto userBuyLotteryReponseDto = new UserBuyLotteryReponseDto();
        Optional<Lottery> lottery = lotteryRepository.findByLotteryId(ticketId).stream().findFirst();
        if (lottery.isEmpty()) {
            throw new NotFoundException(String.format("not found ticket : %s", ticketId));
        } else {
            UserTicket userTicket = new UserTicket();
            if (lottery.get().getAmount() > 0) {
                userTicket.setLottery(lottery.get());
                userTicket.setUserId(userId);
                userTicketRepository.save(userTicket);

                lottery.get().setAmount(lottery.get().getAmount() - 1);
                lotteryRepository.save(lottery.get());

                userBuyLotteryReponseDto = modelMapper.map(userTicket, UserBuyLotteryReponseDto.class);
            } else {
                throw new NotFoundException(String.format("not enough ticket : %s", ticketId));
            }
        }
        return userBuyLotteryReponseDto;
    }

    public UserTicketAllReponseDto GetLotteryByUserId(String userId) {
        UserTicketAllReponseDto userTicketAllReponseDto = new UserTicketAllReponseDto();
        List<UserTicket> userTicketList = userTicketRepository.findAll().stream().filter(r -> r.getUserId().equals(userId)).collect(Collectors.toList());

        long countLottery = userTicketList.stream().mapToInt(r -> r.getLottery().getAmount()).count();
        double sumLottery = userTicketList.stream().mapToDouble(r -> r.getLottery().getPrice()).sum();
        List<String> listLottery = userTicketList.stream().map(r -> r.getLottery().getTicket()).collect(Collectors.toList());
        userTicketAllReponseDto.setTicket(listLottery);
        userTicketAllReponseDto.setCount(countLottery);
        userTicketAllReponseDto.setCost(sumLottery);

        return userTicketAllReponseDto;
    }

    @Transactional
    public UserDeleteTicketResponseDto DeleteLottery(String userId, String ticketId) {
        UserDeleteTicketResponseDto userDeleteTicketResponseDto = new UserDeleteTicketResponseDto();
        List<UserTicket> userTicketList = userTicketRepository.findAll().stream().filter(r -> r.getUserId().equals(userId)).collect(Collectors.toList());
        if (userTicketList.isEmpty()) {
            throw new NotFoundException(String.format("not found user id : %s", userId));
        } else if (userTicketList.stream().noneMatch(r -> r.getLottery().getTicket().equals(ticketId))) {
            throw new NotFoundException(String.format("not found ticket id : %s", ticketId));
        } else {

            List<UserTicket> ticketDelete = userTicketList.stream()
                    .filter(r -> r.getLottery().getTicket().equals(ticketId)).collect(Collectors.toList());

            for (UserTicket lotteryDelete : ticketDelete) {

                Optional<Lottery> lotteryUpdate = lotteryRepository.findById(lotteryDelete.getLottery().getId());
                if (lotteryUpdate.isPresent()) {
                    lotteryUpdate.get().setAmount(lotteryUpdate.get().getAmount() + 1);

                    lotteryRepository.save(lotteryUpdate.get());
                    userTicketRepository.delete(lotteryDelete);
                }
            }

            userDeleteTicketResponseDto.setTicket(ticketId);
        }
        return userDeleteTicketResponseDto;
    }
}
