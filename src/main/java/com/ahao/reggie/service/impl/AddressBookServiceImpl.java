package com.ahao.reggie.service.impl;

import com.ahao.reggie.entity.AddressBook;
import com.ahao.reggie.mapper.AddressBookMapper;
import com.ahao.reggie.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
