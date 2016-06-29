package com.airkisser.mybatis.service;

import com.airkisser.mybatis.base.BaseServiceTests;
import com.airkisser.mybatis.dao.UserMapper;
import com.airkisser.mybatis.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by AIR on 2016/6/30.
 */
public class UserServiceTest extends BaseServiceTests {
    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp(){
        User user = new User();
        user.setName("admin");
        user.setPassword("123");
        userMapper.insertSelective(user);
    }

    @Test
    public void testCountByUserSelective(){
        User user = new User();
        user.setName("admin");
        user.setPassword("123");
        assertEquals(1,userMapper.countByPrimaryKeySelective(user));
        user.setName("john");
        assertEquals(0,userMapper.countByPrimaryKeySelective(user));
    }
}
