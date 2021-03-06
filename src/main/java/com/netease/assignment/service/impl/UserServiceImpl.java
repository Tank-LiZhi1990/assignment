package com.netease.assignment.service.impl;

import com.netease.assignment.dao.IUserDao;
import com.netease.assignment.domain.User;
import com.netease.assignment.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User getUser(String userName) {

        User user = userDao.getUser(userName);

        return user;
    }

}
