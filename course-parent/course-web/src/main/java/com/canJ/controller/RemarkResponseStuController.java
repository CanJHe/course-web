package com.canJ.controller;

import com.canJ.service.RemarkResponseStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 学生回复评论controller
 */
@Controller
@RequestMapping("/remarkResponse/stu")
public class RemarkResponseStuController {

    @Autowired
    private RemarkResponseStuService remarkResponseStuService;



}
