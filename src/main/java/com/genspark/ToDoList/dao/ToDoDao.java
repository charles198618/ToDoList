package com.genspark.ToDoList.dao;

import com.genspark.ToDoList.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoDao extends JpaRepository<ToDo, Integer> {
}
