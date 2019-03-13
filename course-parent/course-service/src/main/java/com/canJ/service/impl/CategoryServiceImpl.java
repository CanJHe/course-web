package com.canJ.service.impl;

import com.canJ.mapper.CategoryMapper;
import com.canJ.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 分类service
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private HttpSession session;
}
