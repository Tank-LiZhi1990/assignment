package com.netease.assignment.dao;

import com.netease.assignment.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    void addUser(User user);

    void deleteUser(Integer id);

    User getUser(String userName);

    List<User> getUsers();

    void updateUser(User user);
}
