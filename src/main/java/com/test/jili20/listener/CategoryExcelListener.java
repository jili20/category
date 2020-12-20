package com.test.jili20.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.jili20.entity.Category;
import com.test.jili20.entity.excel.CategoryData;
import com.test.jili20.exception.Jili20Exception;
import com.test.jili20.service.CategoryService;

/**
 * @author bing  @create 2020/12/20-下午12:05
 */
public class CategoryExcelListener extends AnalysisEventListener<CategoryData> {

    public CategoryService categoryService;

    public CategoryExcelListener() {
    }

    public CategoryExcelListener(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //读取excel内容，一行一行进行读取
    @Override
    public void invoke(CategoryData categoryData, AnalysisContext analysisContext) {
        if (categoryData == null) {
            throw new Jili20Exception(20001, "文件数据为空");
        }
        //一行一行读取，每次读取有两个值，第一个值一级分类，第二个值二级分类
        //判断一级分类是否重复
        Category existOneCategory = this.existOneCategory(categoryService, categoryData.getOneCategoryName());
        if(existOneCategory == null) { //没有相同一级分类，进行添加
            existOneCategory = new Category();
            existOneCategory.setParentId("0");
            existOneCategory.setName(categoryData.getOneCategoryName());//一级分类名称
            categoryService.save(existOneCategory);
        }

        //获取一级分类id值
        String parentId = existOneCategory.getId();

        //添加二级分类
        //判断二级分类是否重复
        Category existTwoCategory = this.existTwoCategory(categoryService, categoryData.getTwoCategoryName(), parentId);
        if(existTwoCategory == null) {
            existTwoCategory = new Category();
            existTwoCategory.setParentId(parentId);
            existTwoCategory.setName(categoryData.getTwoCategoryName());//二级分类名称
            categoryService.save(existTwoCategory);
        }

    }

    //判断一级分类不能重复添加
    private Category existOneCategory(CategoryService categoryService,String name){
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        wrapper.eq("parent_id",0);
        Category oneCategory = categoryService.getOne(wrapper);
        return oneCategory;
    }

    //判断二级分类不能重复添加
    private Category existTwoCategory(CategoryService categoryService,String name,String parentId){
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        wrapper.eq("parent_id",parentId);
        Category twoCategory = categoryService.getOne(wrapper);
        return twoCategory;
    }




    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
