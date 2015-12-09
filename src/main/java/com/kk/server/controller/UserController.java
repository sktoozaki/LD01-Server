package com.kk.server.controller;

import com.kk.server.model.UserBean;
import com.kk.server.service.UserService;
import com.kk.server.service.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by KK on 2015/12/3.
 */

@Controller
public class UserController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private UserServiceImp userService;

    @RequestMapping("/user")
    public @ResponseBody
    UserBean user(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return new UserBean(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/login")
    @ResponseBody
    public String userLogin()
    {
//        userService.userLogin();
        return "userLogin Successful";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String userRegister()
    {
//        userService.userRegister();
        return "userRegister Successful";
    }
}
