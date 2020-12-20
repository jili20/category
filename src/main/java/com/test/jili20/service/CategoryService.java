package com.test.jili20.service;

import com.test.jili20.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文章分类 服务类
 * </p>
 *
 * @author Bing
 * @since 2020-12-20
 */
public interface CategoryService extends IService<Category> {

    // 添加文章分类
    void saveCategory(MultipartFile file, CategoryService categoryService);
}
