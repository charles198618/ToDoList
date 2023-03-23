package com.genspark.ToDoList.Controller;

import com.genspark.ToDoList.entity.LoginUser;
import com.genspark.ToDoList.entity.Task;
import com.genspark.ToDoList.entity.User;
import com.genspark.ToDoList.service.UserService;
import com.genspark.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @PutMapping("/register")
    public void register(@RequestBody User user) {
        this.userService.saveUser(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginUser user) {
        return this.userService.login(user);
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return this.userService.findByUsername(username);
    }

    @PostMapping("/profile/edit")
    public void editProfile(@RequestBody User user) {
        this.userService.updateUser(user);
    }

    @DeleteMapping("/profile/delete")
    public void deleteProfile(@RequestBody User user) {
        this.userService.deleteUser(user);
    }

    @GetMapping("/{userId}/tasks")
    public List<Task> getTasks(@PathVariable int userId) {
        return this.taskService.findAll(userId);
    }

    @GetMapping("/{userId}/tasks/{taskId}")
    public Task getTask(@PathVariable int userId, @PathVariable int taskId) {
        return this.taskService.findByTaskid(taskId);
    }

    @PostMapping("/{userId}/tasks")
    public void addTask(@PathVariable int userId, @RequestBody Task task) {
        this.taskService.saveTask(userId, task);
    }

    @PutMapping("/{userId}/tasks")
    public void updateTask(@PathVariable int userId, @RequestBody Task task) {
        this.taskService.updateTask(userId, task);
    }

    @DeleteMapping("/{userId}/tasks/{taskId}")
    public void deleteTask(@PathVariable int userId, @PathVariable int taskId) {
        this.taskService.deleteTask(taskId);
    }

}
