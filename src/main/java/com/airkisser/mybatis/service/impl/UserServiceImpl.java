package com.airkisser.mybatis.service.impl;

import com.airkisser.mybatis.dao.UserMapper;
import com.airkisser.mybatis.model.User;
import com.airkisser.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by AIR on 2016/6/29.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public long countByUserSelective(User user) {
        return userDao.countByPrimaryKeySelective(user);
    }

    @Override
    public User insertUser(User user) {
        userDao.insertSelective(user);
        return user;
    }
}
