package com.example.stm.controller;

import com.example.stm.entity.TodoEntity;
import com.example.stm.modul.Todo;
import com.example.stm.response.TodoNotFoundException;
import com.example.stm.service.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    //Get
    @GetMapping
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok().body(todoService.getAll());
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    //Post
    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todoEntity, @RequestParam Long user_id){
        try {
            return ResponseEntity.ok().body(todoService.createTodo(todoEntity,user_id));
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/{taskid}/edit")
    public ResponseEntity editTodo(@PathVariable Long taskid,@RequestBody TodoEntity todoEntity) {
        try {
            return ResponseEntity.ok().body(todoService.editTodo(todoEntity, taskid));
        }
        catch (TodoNotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/status")
    public ResponseEntity editTodoStatus(@RequestParam Long id, String status){
        try {
            return ResponseEntity.ok().body(todoService.editStatus(id,status));
        }
        catch (TodoNotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping("/priority")
    public ResponseEntity editTodoPriority(@RequestParam Long id, String priority){
        try {
            return ResponseEntity.ok().body(todoService.editPriority(id,priority));
        }
        catch (TodoNotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/{taskid}/jobtask")
    public  ResponseEntity assignTask(@PathVariable Long taskid, @RequestParam Long user_id){
        try {
            return ResponseEntity.ok().body(todoService.assignTask(taskid,user_id));
        }
//        catch (TodoNotFoundException e) {
//            return  ResponseEntity.badRequest().body(e.getMessage());
//        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
