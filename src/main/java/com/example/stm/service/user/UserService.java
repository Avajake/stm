package com.example.stm.service.user;

import com.example.stm.entity.UserEntity;
import com.example.stm.modul.User;
import com.example.stm.response.UserAlreadFindException;
import com.example.stm.response.UserNotFoundException;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User registration(UserEntity user) throws UserAlreadFindException;
    User getUserById(Long id) throws UserNotFoundException;
}
