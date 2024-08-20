package com.example.stm.response;

public class TodoNotFoundException extends  Exception{
    public TodoNotFoundException(String message) {
        super(message);
    }
}
