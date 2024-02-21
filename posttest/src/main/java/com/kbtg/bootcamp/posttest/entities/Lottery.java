package com.kbtg.bootcamp.posttest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Lottery {
    @Id
    @GeneratedValue
    private long Id;
    private String TicketId;
    private float Price;
}