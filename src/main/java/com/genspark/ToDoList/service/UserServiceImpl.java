package com.genspark.ToDoList.service;

import com.genspark.ToDoList.dao.UserDao;
import com.genspark.ToDoList.entity.LoginUser;
import com.genspark.ToDoList.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        this.userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        for (User user : this.userDao.findAll()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByUserid(int userid) {
        return this.userDao.findById(userid).orElse(null);
    }

    @Override
    public void updateUser(User user) {
        User user1 = this.findByUserid(user.getUserid());
        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setUsername(user.getUsername());
        this.userDao.save(user1);
    }

    @Override
    public void deleteUser(User user) {
        this.userDao.delete(user);
    }

    @Override
    public boolean login(LoginUser user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(this.findByUsername(user.getUsername()).getPassword());

        return this.findByUsername(user.getUsername()).getPassword().equals(user.getPassword());
    }
}
