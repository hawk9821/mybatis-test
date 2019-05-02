package com.hawk.controller;

import com.hawk.entity.User;
import com.hawk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangdonghao
 * @date 2019/4/15
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/users/{id}")
    @ResponseBody
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
}
