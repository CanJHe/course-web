package com.canJ.controller;

import com.canJ.pojo.PostsTea;
import com.canJ.pojo.StuPost;
import com.canJ.pojo.Teacher;
import com.canJ.service.PostsTeaService;
import com.canJ.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 教师发帖Controller
 */
@Controller
@RequestMapping("/posts/tea")
public class PostsTeaController {

    @Autowired
    private PostsTeaService postsTeaService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private HttpSession session;

    @RequestMapping("/allPost")
    public ModelAndView findAllPost(){
        ModelAndView modelAndView = new ModelAndView();
        List<PostsTea> all = postsTeaService.findAll();
        List<StuPost> posts = new ArrayList<>();
        for (PostsTea post: all
        ) {
            StuPost stuPost = new StuPost();
            stuPost.setContent(post.getContent());
            stuPost.setPostId(post.getPostid());
            stuPost.setTime(post.getPostdate());
            stuPost.setStuId(post.getTeacherid());
            Teacher byId = teacherService.findById(post.getTeacherid());
            stuPost.setStuName(byId.getName());
            posts.add(stuPost);
        }
        modelAndView.addObject("postStu",posts);
        modelAndView.setViewName("teaPosts");
        return modelAndView;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(String content){
        PostsTea postsTea = new PostsTea();
        Teacher teacher =(Teacher) session.getAttribute("teacher");
        postsTea.setTeacherid(teacher.getTeacherid());
        postsTea.setContent(content);
        postsTea.setPostdate(new Date());
        boolean b = postsTeaService.insert(postsTea);
        if (b){
            return "true";
        }
        return "false";
    }

}
