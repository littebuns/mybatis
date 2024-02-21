package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.VO.UserVO;
import com.example.mybatisplus.model.common.PageRequestModel;
import com.example.mybatisplus.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xxb
 * @since 2021-10-28
 */
public interface UserService extends IService<User> {

    List<User> list(User user);

    Page<UserVO> pageList(PageRequestModel<User> user);
}
