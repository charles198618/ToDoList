package com.genspark.ToDoList.Controller;

import com.genspark.ToDoList.entity.LoginUser;
import com.genspark.ToDoList.entity.ToDo;
import com.genspark.ToDoList.entity.User;
import com.genspark.ToDoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private UserService userService;

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

//    @Autowired
//    private com.genspark.ToDoList.service.ToDoService ToDoService;
//
//    @GetMapping("/")
//    public String home() {
//        return "<HTML><H1>Welcome to our To Do List App</H1></HTML>";
//    }
//
//        @GetMapping("/tasks")
//    public List<ToDo> getTasks(){
//        return this.ToDoService.getAllToDo();
//    }
//
//    @GetMapping("/tasks/{taskID}")
//    private ToDo getToDo(@PathVariable String taskID) {
//        return this.ToDoService.getToDoById(Integer.parseInt(taskID));
//    }
//
//    @PostMapping("/tasks")
//    public ToDo addToDo(@RequestBody ToDo task) {
//        return this.ToDoService.addToDo(task);
//    }
//
//    @PutMapping("/tasks")
//    public ToDo updateToDo(@RequestBody ToDo task) {
//    return this.ToDoService.updateToDo(task);
//    }
//
//    @DeleteMapping("/tasks/{taskID}")
//    private String deleteToDo(@PathVariable String taskID) {
//        return this.ToDoService.deleteToDoById(Integer.parseInt(taskID));
//    }


}
