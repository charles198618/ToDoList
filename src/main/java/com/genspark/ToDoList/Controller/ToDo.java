package com.genspark.ToDoList.Controller;

import jakarta.persistence.*;

@Entity

public class ToDo {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid; //primary key
    private String emailId;
    private String password;
    private String firstname;
    private String lastname;
    private String taskdescription;

    public ToDo() {
    }

    public ToDo( String emailId, String password, String firstname, String lastname, String taskdescription) {
        this.emailId = emailId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
