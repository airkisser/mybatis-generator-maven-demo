package com.airkisser.mybatis.web;

import com.airkisser.mybatis.model.User;
import com.airkisser.mybatis.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AIR on 2016/6/29.
 */
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String name, String password, HttpServletRequest request, RedirectAttributes attrs){
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
            attrs.addFlashAttribute("error","用户名或密码不能为空");
            return "redirect:/";
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        if(userService.countByUserSelective(user) <= 0){
            attrs.addFlashAttribute("error","用户名或密码错误");
            return "redirect:/";
        }
        request.getSession().setAttribute("user",user);
        return "redirect:/home";
    }

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String home(){
        return "welcome";
    }
}
