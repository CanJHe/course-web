package com.canJ.controller;

import com.canJ.pojo.ResponseCollectionBody;
import com.canJ.service.CollectionTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 教师收藏Controller
 */
@Controller
@RequestMapping("/collection/tea")
public class CollectionTeaController {

    @Autowired
    private CollectionTeaService collectionTeaService;

    @RequestMapping("/resource/{resourceId}")
    public String collectResource(@PathVariable int resourceId){
        boolean result = collectionTeaService.collectResource(resourceId);
        if (result){
            return "redirect:/collection/tea/resources";
        }
        return "error/error";
    }

    @RequestMapping("/cancelResource/{resourceId}")
    public String cancelResource(@PathVariable int resourceId){
        boolean result = collectionTeaService.cancelCollectResource(resourceId);
        if (result){
            return "redirect:/collection/tea/resources";
        }
        return "error/error";
    }

    @RequestMapping("/resources")
    public String showMyCollections(RedirectAttributes attributes){
        List<ResponseCollectionBody> collectionBodies = collectionTeaService.selectMyCollection();
        if (collectionBodies.size() > 0){
            attributes.addFlashAttribute("collections",collectionBodies);
        }
        return "collectionDetail";
    }

}
