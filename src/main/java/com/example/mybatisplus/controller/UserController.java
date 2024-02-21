package com.example.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.entity.User;
import com.example.mybatisplus.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xxb
 * @since 2021-10-28
 */
@RestController
@Tag(name = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/list")
    @Operation(summary = "获取用户列表")
    public List<User> list(@RequestBody User user){
        return userService.list(user);
    }


    @PostMapping("/pageList")
    @Operation(summary = "分页查询用户")
    public Page<User> pageList(@RequestBody User user){
        return userService.pageList(user);
    }


}

