package com.kbtg.bootcamp.posttest.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_ticket")
public class UserTicket {
    @Id
    @GeneratedValue
    private long Id;
    private String UserId;

    @ManyToOne
    @JoinColumn(name = "lottery_id")
    private Lottery lottery;
}