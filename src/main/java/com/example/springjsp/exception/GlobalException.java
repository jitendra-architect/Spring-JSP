package com.example.springjsp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(AgeNotValidException.class)
    public ResponseEntity<ProblemDetail> ageNotValidException(AgeNotValidException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle(ex.getMessage());
        problemDetail.setDetail("You are not allowed");
        problemDetail.setType(URI.create("http://localhost:8080/vote/age"));
        problemDetail.setProperty("Host", "localhost");
        //ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
        return new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST);
    }
}
