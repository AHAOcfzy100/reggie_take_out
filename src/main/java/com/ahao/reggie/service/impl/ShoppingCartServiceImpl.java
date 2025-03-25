package com.ahao.reggie.service.impl;

import com.ahao.reggie.entity.ShoppingCart;
import com.ahao.reggie.mapper.ShoppingCartMapper;
import com.ahao.reggie.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
