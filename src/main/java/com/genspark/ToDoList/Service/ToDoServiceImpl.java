package com.genspark.ToDoList.Service;

import com.genspark.ToDoList.Dao.ToDoDao;
import com.genspark.ToDoList.Entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

        @Autowired
    private ToDoDao todoDao;
    @Override
    public List<ToDo> getAllToDo() {

        return this.todoDao.findAll();
    }
    @Override
    public ToDo getToDoById(int taskID) {
        Optional<ToDo> c = this.todoDao.findById(taskID);
        ToDo todo = null;
        if(c.isPresent()) {
            todo = c.get();
        }
        else {
            throw new RuntimeException(" task is not found for id :: " + taskID);
        }
        return todo;
    }

    @Override
    public ToDo addToDo(ToDo todo) {
         return this.todoDao.save(todo);
    }

   @Override
    public ToDo updateToDo(ToDo todo) {
        return this.todoDao.save(todo);
   }


    @Override
   public String deleteToDoById(int taskID) {

         this.todoDao.deleteById(taskID);

        return "Deleted Successfully";
    }
}



