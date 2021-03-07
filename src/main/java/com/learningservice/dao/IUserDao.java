package com.learningservice.dao;
import org.springframework.security.core.userdetails.User;

public interface IUserDao {
    public User findUserByname(String name);
}
