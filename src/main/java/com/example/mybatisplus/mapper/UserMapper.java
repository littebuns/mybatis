package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xxb
 * @since 2021-10-28
 */
public interface UserMapper extends BaseMapper<User> {

    void updateAge(@Param(Constants.WRAPPER)LambdaQueryWrapper<User> wrapper, @Param("age") Integer age);

}
