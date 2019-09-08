package com.it.cn.service;

import com.it.cn.dao.CategoryDao;
import com.it.cn.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public List<Category> findList(Category entity) {
        return categoryDao.findList(entity);
    }
}
