package com.test.jili20.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author bing  @create 2020/12/20-下午12:01
 */
@Data
public class CategoryData {

    // 一级分类
    @ExcelProperty(index = 0)
    private String oneCategoryName;

    // 二级分类
    @ExcelProperty(index = 1)
    private String twoCategoryName;
}
