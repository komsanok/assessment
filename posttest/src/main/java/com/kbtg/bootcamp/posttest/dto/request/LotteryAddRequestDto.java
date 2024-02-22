package com.kbtg.bootcamp.posttest.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class LotteryAddRequestDto {
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
