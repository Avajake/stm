package com.example.stm.modul;

import com.example.stm.entity.UserEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class User {
   private Long id;
   private String username;
   private List<Todo> todo;

   public static User toModel(UserEntity user) {
      User model = new User();
      model.setId(user.getId());
      model.setUsername(user.getUsername());

      return model;
   }
}
