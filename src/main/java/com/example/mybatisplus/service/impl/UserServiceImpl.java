package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xxb
 * @since 2021-10-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> list(User user) {
        return lambdaQuery().eq(Objects.nonNull(user.getId()), User::getId, user.getId())
                .gt(Objects.nonNull(user.getAge()), User::getAge, user.getAge())
                .list();
    }

    @Override
    public Page<User> pageList(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        Page<User> page = new Page<>(1, 2);
        page.addOrder(new OrderItem("age", false));
        return this.page(page, queryWrapper);
    }

}
