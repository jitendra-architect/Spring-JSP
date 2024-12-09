package com.example.springjsp.exception;

public class AgeNotValidException extends RuntimeException{
    public AgeNotValidException(){
        super();
    }
    public AgeNotValidException(String message){
        super(message);
    }
}
