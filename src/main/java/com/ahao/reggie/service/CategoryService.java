package com.ahao.reggie.service;

import com.ahao.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CategoryService extends IService<Category> {
    public void remove (Long id);
}
