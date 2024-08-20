package com.example.stm.controller;

import com.example.stm.entity.UserEntity;
import com.example.stm.modul.User;
import com.example.stm.response.UserAlreadFindException;
import com.example.stm.response.UserNotFoundException;
import com.example.stm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id)  {
        try {
            return ResponseEntity.ok().body(userService.getUserById(id));
        }
        catch (UserNotFoundException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/addUser")
    public  ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok().body(userService.registration(user));
        }
        catch (UserAlreadFindException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Произошла ошибка :" + e);
        }
    }

    @PostMapping("/auth")
    public ResponseEntity authUser()
    {
        return ResponseEntity.ok().body("Вход успешно произошел");
    }

}
