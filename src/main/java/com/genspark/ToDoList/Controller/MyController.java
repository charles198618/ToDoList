package com.genspark.ToDoList.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private ToDoService ToDoService;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to our To Do List App</H1></HTML>";
    }

        @GetMapping("/tasks")
    public List<ToDo> getTasks(){
        return this.ToDoService.getAllToDo();
    }

    @GetMapping("/tasks/{taskID}")
    private ToDo getToDo(@PathVariable String taskID) {
        return this.ToDoService.getToDoById(Integer.parseInt(taskID));
    }

    @PostMapping("/tasks")
    public ToDo addToDo(@RequestBody ToDo task) {
        return this.ToDoService.addToDo(task);
    }

    @PutMapping("/tasks")
    public ToDo updateToDo(@RequestBody ToDo task) {
    return this.ToDoService.updateToDo(task);
    }

    @DeleteMapping("/tasks/{taskID}")
    private String deleteToDo(@PathVariable String taskID) {
        return this.ToDoService.deleteToDoById(Integer.parseInt(taskID));
    }


}
