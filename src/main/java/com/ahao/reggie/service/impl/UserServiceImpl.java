package com.ahao.reggie.service.impl;

import com.ahao.reggie.entity.User;
import com.ahao.reggie.mapper.UserMapper;
import com.ahao.reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
