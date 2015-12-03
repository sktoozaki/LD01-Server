package com.kk.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KK on 2015/12/3.
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "This is LD's index!";
    }

}