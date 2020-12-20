package com.test.jili20.service.impl;

import com.alibaba.excel.EasyExcel;
import com.test.jili20.entity.Category;
import com.test.jili20.entity.excel.CategoryData;
import com.test.jili20.listener.CategoryExcelListener;
import com.test.jili20.mapper.CategoryMapper;
import com.test.jili20.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 * 文章分类 服务实现类
 * </p>
 *
 * @author Bing
 * @since 2020-12-20
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    // 添加文章分类
    @Override
    public void saveCategory(MultipartFile file, CategoryService categoryService) {
        try {
            //获取文件输入流
            InputStream in = file.getInputStream();
            //调用方法进行读取
            EasyExcel.read(in, CategoryData.class,new CategoryExcelListener(categoryService)).sheet().doRead();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

