package com.kbtg.bootcamp.posttest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setDateTime(ZonedDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ DataDuplicateException.class })
    public ResponseEntity<Object> handleDataDuplicateException(DataDuplicateException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setDateTime(ZonedDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
