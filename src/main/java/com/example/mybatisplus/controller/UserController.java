package com.example.mybatisplus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xxb
 * @since 2021-10-28
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}

