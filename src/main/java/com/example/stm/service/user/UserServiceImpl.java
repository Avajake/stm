package com.example.stm.service.user;

import com.example.stm.entity.UserEntity;
import com.example.stm.modul.User;
import com.example.stm.repository.UserRepo;
import com.example.stm.response.UserAlreadFindException;
import com.example.stm.response.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService  {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registration(UserEntity user) throws UserAlreadFindException {
        if (userRepo.findByUsername(user.getUsername()).isPresent())
            throw new UserAlreadFindException("Пользователь с таким именем существует!");
        if (userRepo.findByEmail(user.getEmail()).isPresent())
            throw new UserAlreadFindException("Пользователь с такой почтой существует!");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return  User.toModel(user);
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }
}
