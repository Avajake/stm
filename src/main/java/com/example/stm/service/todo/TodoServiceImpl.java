package com.example.stm.service.todo;

import com.example.stm.entity.TodoEntity;
import com.example.stm.entity.UserEntity;
import com.example.stm.modul.Todo;
import com.example.stm.repository.TodoRepo;
import com.example.stm.repository.UserRepo;
import com.example.stm.response.TodoNotFoundException;
import com.example.stm.response.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Todo> getAll() {
        List<TodoEntity> todoEntities = todoRepo.findAll();
        return todoEntities.stream().map(Todo::toModel).collect(Collectors.toList());
    }

    @Override
    public Todo createTodo(TodoEntity todoEntity, Long user_id){
        UserEntity user = userRepo.findById(user_id).get();
        todoEntity.setAuthor(user);
        return Todo.toModel(todoRepo.save(todoEntity));
    }

    @Override
    public Todo editTodo(TodoEntity todoEntity, Long id) throws TodoNotFoundException {
        TodoEntity todo = todoRepo.findById(id).orElse(null);
        if (todo == null)
            throw new TodoNotFoundException("Данная задача не найдена");

        todo.setTitle(todoEntity.getTitle());
        todo.setDescription(todoEntity.getDescription());
        return Todo.toModel(todoRepo.save(todo));
    }

    @Override
    public Todo editStatus(Long id, String status) throws TodoNotFoundException {
        TodoEntity todo = todoRepo.findById(id).orElse(null);
        if (todo == null) {
            throw new TodoNotFoundException("Данная задача не найдена");
        }
        todo.setStatus(status);
        return Todo.toModel(todoRepo.save(todo));
    }

    @Override
    public Todo editPriority(Long id, String priority) throws TodoNotFoundException {
        TodoEntity todo = todoRepo.findById(id).orElse(null);
        if (todo == null) {
            throw new TodoNotFoundException("Данная задача не найдена");
        }
        todo.setPriority(priority);
        return Todo.toModel(todoRepo.save(todo));
    }

    @Override
    public Todo assignTask(Long taskid, Long user_id) throws UserNotFoundException, TodoNotFoundException {
        UserEntity user = userRepo.findById(user_id).orElse(null);
        TodoEntity todo = todoRepo.findById(taskid).orElseThrow((() -> new RuntimeException("Task not found")));
        if (user == null) {
            throw new UserNotFoundException("Данного пользователя не найдено");
        }
        if (todo == null) {
            throw new TodoNotFoundException("Данная задача не найдена");
        }
        todo.setAssignee(user);
        return Todo.toModel(todoRepo.save(todo));
    }
}
