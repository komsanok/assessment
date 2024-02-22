package com.kbtg.bootcamp.posttest.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserTicketAllReponseDto {
    private List<String> Ticket;
    private int Count;
    private float Cost;
}
