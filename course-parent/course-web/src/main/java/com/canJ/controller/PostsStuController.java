package com.canJ.controller;

import com.canJ.pojo.PostsStu;
import com.canJ.pojo.StuPost;
import com.canJ.pojo.Student;
import com.canJ.service.PostsStuService;
import com.canJ.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 学生发帖Controller
 */
@Controller
@RequestMapping("/posts/stu")
public class PostsStuController {

    @Autowired
    private PostsStuService postsStuService;

    @Autowired
    private HttpSession session;

    @Autowired
    private StudentService studentService;

    private Logger logger = LoggerFactory.getLogger(PostsStuController.class);

    @RequestMapping("/allPost")
    public ModelAndView findAllPost(){
        ModelAndView modelAndView = new ModelAndView();
        List<PostsStu> all = postsStuService.findAll();
        List<StuPost> posts = new ArrayList<>();
        for (PostsStu post: all
        ) {
            StuPost stuPost = new StuPost();
            stuPost.setContent(post.getContent());
            stuPost.setPostId(post.getPostid());
            stuPost.setTime(post.getPostdate());
            stuPost.setStuId(post.getStudentid());
            Student byId = studentService.findById(post.getStudentid());
            stuPost.setStuName(byId.getName());
            stuPost.setStuState(byId.getStuState());
            posts.add(stuPost);
        }
        modelAndView.addObject("postStu",posts);
        modelAndView.setViewName("stuPosts");
        return modelAndView;
    }


    @RequestMapping("/myPosts")
    public String myPosts(Model model){
        List<StuPost> postsStus = postsStuService.finaMyPosts();
        if (postsStus != null){
            model.addAttribute("postStu",postsStus);
            return "myPosts";
        }
        return "error/error";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(String content){
        PostsStu postsStu = new PostsStu();
        logger.info(content);
        Student student =(Student) session.getAttribute("student");
        postsStu.setStudentid(student.getStudentid());
        postsStu.setContent(content);
        postsStu.setPostdate(new Date());
        boolean b = postsStuService.insert(postsStu);
        if (b){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/deletePosts/{postId}")
    public String deletePosts(@PathVariable int postId){
        boolean result = postsStuService.deletePost(postId);
        if (result){
            return "redirect:/posts/stu/allPost";
        }
        return "error/error";
    }



}
