package com.genspark.ToDoList.Entity;

import jakarta.persistence.*;

@Entity
//@Table(name = "todo_table")
public class ToDo {

    @Id
//    @Column(name = "t_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid; //primary key
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String taskdescription;

    public ToDo() {
    }

    public ToDo( String username, String password, String firstname, String lastname, String taskdescription) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.taskdescription = taskdescription;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTaskdescription() {
        return taskdescription;
    }

    public void setTaskdescription(String taskdescription) {
        this.taskdescription = taskdescription;
    }
}
