package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.VO.UserVO;
import com.example.mybatisplus.model.common.PageRequestModel;
import com.example.mybatisplus.model.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.example.mybatisplus.utils.MybatisPlusUtil;
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
    public Page<UserVO> pageList(PageRequestModel<User> user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user.getModel());
        Page<User> page = user.getMpPage();
        Page<User> userPage = this.page(page, queryWrapper);
        return MybatisPlusUtil.convertVO(userPage, UserVO.class);

    }

}
