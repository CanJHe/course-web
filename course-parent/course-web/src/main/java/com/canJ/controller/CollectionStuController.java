package com.canJ.controller;

import com.canJ.pojo.ResponseCollectionBody;
import com.canJ.service.CollectionStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 学生收藏Controller
 */
@Controller
@RequestMapping("/collection/stu")
public class CollectionStuController {

    @Autowired
    private CollectionStuService collectionStuService;

    @RequestMapping("/resource/{resourceId}")
    public String collectResource(@PathVariable int resourceId,Model model){
        boolean result = collectionStuService.collectResource(resourceId);
        if (result){
            return "redirect:/collection/stu/resources";
        }
        return "error/error";
    }

    @RequestMapping("/cancelResource/{resourceId}")
    public String cancelResource(@PathVariable int resourceId){
        boolean result = collectionStuService.cancelCollectResource(resourceId);
        if (result){
            return "redirect:/collection/stu/resources";
        }
        return "error/error";
    }

    @RequestMapping("/resources")
    public String showMyCollections(Model model){
        List<ResponseCollectionBody> collectionBodies = collectionStuService.selectMyCollection();
        if (collectionBodies.size() > 0){
            model.addAttribute("collections",collectionBodies);
        }
        return "collectionDetail";
    }

}
