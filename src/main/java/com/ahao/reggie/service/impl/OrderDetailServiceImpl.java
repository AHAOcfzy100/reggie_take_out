package com.ahao.reggie.service.impl;

import com.ahao.reggie.entity.OrderDetail;
import com.ahao.reggie.mapper.OrderDetailMapper;
import com.ahao.reggie.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
