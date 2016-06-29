package com.airkisser.mybatis.web;

import com.airkisser.mybatis.base.BaseControllerTests;
import com.airkisser.mybatis.model.User;
import com.airkisser.mybatis.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by AIR on 2016/6/30.
 */
public class UserControllerTest extends BaseControllerTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private UserService userService;
    private MockMvc mockMvc;


    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        User user = new User();
        user.setName("tom");
        user.setPassword("123");
        userService.insertUser(user);
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(post("/login")).andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "用户名或密码不能为空")).andExpect(redirectedUrl("/"));
        mockMvc.perform(post("/login").param("name", "tom")).andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "用户名或密码不能为空")).andExpect(redirectedUrl("/"));
        mockMvc.perform(post("/login").param("password", "123")).andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "用户名或密码不能为空")).andExpect(redirectedUrl("/"));
        mockMvc.perform(post("/login").param("name", "bill").param("password", "123")).andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "用户名或密码错误")).andExpect(redirectedUrl("/"));
        mockMvc.perform(post("/login").param("name", "tom").param("password", "123456")).andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "用户名或密码错误")).andExpect(redirectedUrl("/"));
        mockMvc.perform(post("/login").param("name", "bill").param("password", "123456")).andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "用户名或密码错误")).andExpect(redirectedUrl("/"));
        mockMvc.perform(post("/login").param("name", "tom").param("password", "123")).andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/home"));
    }

}
