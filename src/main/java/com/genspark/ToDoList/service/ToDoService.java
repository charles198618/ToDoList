package com.genspark.ToDoList.service;

import com.genspark.ToDoList.entity.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllToDo();
    ToDo getToDoById(int taskID);
    ToDo addToDo(ToDo task);
    ToDo updateToDo(ToDo task);
    String deleteToDoById(int taskID);
}
