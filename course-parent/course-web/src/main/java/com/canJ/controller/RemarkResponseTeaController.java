package com.canJ.controller;

import com.canJ.service.RemarkResponseTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 教师回复评论controller
 */
@Controller
@RequestMapping("/remarkResponse/tea")
public class RemarkResponseTeaController {

    @Autowired
    private RemarkResponseTeaService remarkResponseTeaService;



}
