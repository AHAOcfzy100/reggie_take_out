package com.ahao.reggie.dto;

import com.ahao.reggie.entity.Setmeal;
import com.ahao.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
