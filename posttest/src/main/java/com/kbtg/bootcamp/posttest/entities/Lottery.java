package com.kbtg.bootcamp.posttest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Lottery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Size(min = 6,max = 6, message = "ticket length equal to 6")
    @Pattern(regexp = "^\\d{6}$", message = "ticket input numbers")
    @NotNull(message = "ticket is not null")
    private String Ticket;

    @NotNull(message = "price is not null")
    @Min(value = 0,message = "price more than 0")
    private float Price;

    @NotNull(message = "amount is not null")
    @Min(value = 0,message = "amount more than 0")
    private int Amount;
}