package com.genspark.ToDoList.Dao;

import com.genspark.ToDoList.Entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoDao extends JpaRepository<ToDo, Integer> {
}
