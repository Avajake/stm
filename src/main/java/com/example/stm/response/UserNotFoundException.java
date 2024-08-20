package com.example.stm.response;

public class UserNotFoundException extends  Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
