package com.airkisser.mybatis.dao;

import com.airkisser.mybatis.base.BaseRepositoryTests;
import com.airkisser.mybatis.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by AIR on 2016/6/30.
 */
public class UserMapperTest extends BaseRepositoryTests {
    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp(){
        User user = new User();
        user.setName("tom");
        user.setPassword("123");
        userMapper.insertSelective(user);
    }

    @Test
    public void testCountByPrimaryKeySelective(){
        User user = new User();
        user.setName("tom");
        user.setPassword("123");
        assertEquals(1,userMapper.countByPrimaryKeySelective(user));
    }
}
