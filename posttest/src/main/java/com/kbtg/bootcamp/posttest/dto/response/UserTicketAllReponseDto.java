package com.kbtg.bootcamp.posttest.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserTicketAllReponseDto {
    private List<String> Ticket;
    private Long Count;
    private double Cost;
}
