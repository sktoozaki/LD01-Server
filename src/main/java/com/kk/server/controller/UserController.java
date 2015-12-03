package com.kk.server.controller;

import com.kk.server.model.UserBean;
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
@RequestMapping("/user")
public class UserController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    UserBean user(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return new UserBean(counter.incrementAndGet(), String.format(template, name));
    }
}
