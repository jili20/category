package com.test.jili20.controller;


import com.test.jili20.exception.Jili20Exception;
import com.test.jili20.service.CategoryService;
import com.test.jili20.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文章分类 前端控制器
 * </p>
 *
 * @author Bing
 * @since 2020-12-20
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 添加文章分类
    @PostMapping("/addCategory")
    public R addCategory(MultipartFile file){

        if (file == null) {
            return R.error().message("请上传文件");
        }
        categoryService.saveCategory(file,categoryService);
        return R.ok();
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }



}

