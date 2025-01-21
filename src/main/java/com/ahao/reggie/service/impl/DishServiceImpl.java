package com.ahao.reggie.service.impl;

import com.ahao.reggie.entity.Dish;
import com.ahao.reggie.mapper.DishMapper;
import com.ahao.reggie.service.DishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
