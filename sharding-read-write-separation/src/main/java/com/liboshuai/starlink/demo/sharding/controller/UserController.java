package com.liboshuai.starlink.demo.sharding.controller;

import com.liboshuai.starlink.demo.sharding.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        userService.hello();
        return "hello";
    }
}
