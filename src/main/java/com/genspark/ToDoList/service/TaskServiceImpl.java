package com.genspark.ToDoList.service;

import com.genspark.ToDoList.dao.TaskDao;
import com.genspark.ToDoList.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<Task> findAll(int userid) {
       return this.taskDao.findAll().stream().filter(task -> task.getUserid() == userid).toList();
    }

    @Override
    public void saveTask(int userid, Task task) {
        this.taskDao.save(task);
    }

    @Override
    public Task findByTaskid(int taskid) {
        return this.taskDao.findById(taskid).orElse(null);
    }
//
    @Override
    public void updateTask(int userId, Task task) {
        System.out.println("Update");
        System.out.println(task);
        for (Task t : this.findAll(userId)) {
            if (t.getId() == task.getId()) {
                System.out.println("Found");
                Task newTask = new Task();
                newTask.setId(t.getId());
                newTask.setDescription(task.getDescription());
                newTask.setDueDate(task.getDueDate());
                newTask.setStatus(task.getStatus());
                newTask.setTitle(task.getTitle());
                newTask.setUserid(userId);
                this.taskDao.save(newTask);
            }
        }
    }

    @Override
    public void deleteTask(int taskid) {
        this.taskDao.deleteById(taskid);
    }
}
