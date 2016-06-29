package com.airkisser.mybatis.service;

import com.airkisser.mybatis.model.User;

/**
 * Created by AIR on 2016/6/29.
 */
public interface UserService {

    long countByUserSelective(User user);

    User insertUser(User user);
}
