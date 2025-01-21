package com.ahao.reggie.service.impl;

import com.ahao.reggie.entity.Employee;
import com.ahao.reggie.mapper.EmployeeMapper;
import com.ahao.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
