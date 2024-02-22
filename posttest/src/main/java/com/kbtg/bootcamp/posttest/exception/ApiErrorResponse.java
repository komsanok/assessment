package com.kbtg.bootcamp.posttest.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ApiErrorResponse {
    private  String message;
    private  HttpStatus httpStatus;
    private  ZonedDateTime dateTime;
}
