package com.canJ.controller;

import com.canJ.pojo.*;
import com.canJ.service.*;
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
 * 评论Controller
 */
@Controller
@RequestMapping("/remark")
public class RemarkController {

    @Autowired
    private RemarkService remarkService;

    @Autowired
    private PostsStuService postsStuService;

    @Autowired
    private PostsTeaService postsTeaService;

    @Autowired
    private HttpSession session;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/stuRemark")
    public ModelAndView stuRemark(Integer postId){
        ModelAndView modelAndView = new ModelAndView();
        Remark remark = new Remark();
        remark.setPostidStu(postId);
        List<Remark> all = remarkService.findAll(remark);
        PostsStu byId = postsStuService.findById(postId);
        StuPost stuPost = new StuPost();
        stuPost.setStuId(byId.getStudentid());
        stuPost.setTime(byId.getPostdate());
        stuPost.setContent(byId.getContent());
        stuPost.setPostId(byId.getPostid());
        Student byId1 = studentService.findById(byId.getStudentid());
        stuPost.setStuName(byId1.getName());
        modelAndView.addObject("post",stuPost);
        List<StuRemark> remarks = new ArrayList<>();
        for (Remark re: all
        ) {
            StuRemark stuRemark = new StuRemark();
            stuRemark.setContent(re.getRemarkContext());
            stuRemark.setDate(re.getRemarkTime());
            stuRemark.setStuId(re.getStudentid());
            Student byId2 = studentService.findById(re.getStudentid());
            stuRemark.setName(byId2.getName());
            remarks.add(stuRemark);
        }
        modelAndView.addObject("remarks",remarks);
        modelAndView.setViewName("stuRemark");
        return modelAndView;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseJson insert(String postId,String content){
        ResponseJson responseJson = new ResponseJson();
        Remark remark = new Remark();
        remark.setPostidStu(Integer.parseInt(postId));
        remark.setRemarkContext(content);
        Student student = (Student) session.getAttribute("student");
        remark.setStudentid(student.getStudentid());
        remark.setRemarkTime(new Date());
        boolean insert = remarkService.insert(remark);
        if (insert){
            responseJson.setFlag("true");
            responseJson.setMessage(postId);
            return responseJson;
        }
        responseJson.setFlag("false");
        return responseJson;
    }

    @RequestMapping("/flush")
    public ModelAndView flush(String postId){
        ModelAndView modelAndView = new ModelAndView();
        Remark remark = new Remark();
        remark.setPostidStu(Integer.parseInt(postId));
        List<Remark> all = remarkService.findAll(remark);
        PostsStu byId = postsStuService.findById(Integer.parseInt(postId));
        StuPost stuPost = new StuPost();
        stuPost.setStuId(byId.getStudentid());
        stuPost.setTime(byId.getPostdate());
        stuPost.setContent(byId.getContent());
        stuPost.setPostId(byId.getPostid());
        Student byId1 = studentService.findById(byId.getStudentid());
        stuPost.setStuName(byId1.getName());
        modelAndView.addObject("post",stuPost);
        List<StuRemark> remarks = new ArrayList<>();
        for (Remark re: all
        ) {
            StuRemark stuRemark = new StuRemark();
            stuRemark.setContent(re.getRemarkContext());
            stuRemark.setDate(re.getRemarkTime());
            stuRemark.setStuId(re.getStudentid());
            Student byId2 = studentService.findById(re.getStudentid());
            stuRemark.setName(byId2.getName());
            remarks.add(stuRemark);
        }
        modelAndView.addObject("remarks",remarks);
        modelAndView.setViewName("stuRemark");
        return modelAndView;
    }

    @RequestMapping("/teaRemark")
    public ModelAndView teaRemark(Integer postId){
        ModelAndView modelAndView = new ModelAndView();
        Remark remark = new Remark();
        remark.setPostidTea(postId);
        List<Remark> all = remarkService.findTeaAll(remark);
        // PostsStu byId = postsStuService.findById(postId);
        PostsTea byId = postsTeaService.findById(postId);
        StuPost stuPost = new StuPost();
        stuPost.setStuId(byId.getTeacherid());
        stuPost.setTime(byId.getPostdate());
        stuPost.setContent(byId.getContent());
        stuPost.setPostId(byId.getPostid());
        Student byId1 = studentService.findById(byId.getTeacherid());
        stuPost.setStuName(byId1.getName());
        modelAndView.addObject("post",stuPost);
        List<StuRemark> remarks = new ArrayList<>();
        for (Remark re: all
        ) {
            StuRemark stuRemark = new StuRemark();
            stuRemark.setContent(re.getRemarkContext());
            stuRemark.setDate(re.getRemarkTime());
            stuRemark.setStuId(re.getStudentid());
            Student byId2 = studentService.findById(re.getStudentid());
            stuRemark.setName(byId2.getName());
            remarks.add(stuRemark);
        }
        modelAndView.addObject("remarks",remarks);
        modelAndView.setViewName("teaRemark");
        return modelAndView;
    }

    @RequestMapping("/insertTea")
    @ResponseBody
    public ResponseJson insertTea(String postId,String content){
        ResponseJson responseJson = new ResponseJson();
        Remark remark = new Remark();
        remark.setPostidTea(Integer.parseInt(postId));
        remark.setRemarkContext(content);
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        remark.setTeacherid(teacher.getTeacherid());
        remark.setRemarkTime(new Date());
        boolean insert = remarkService.insertTea(remark);
        if (insert){
            responseJson.setFlag("true");
            responseJson.setMessage(postId);
            return responseJson;
        }
        responseJson.setFlag("false");
        return responseJson;
    }

    @RequestMapping("/flushTea")
    public ModelAndView flushTea(String postId){
        ModelAndView modelAndView = new ModelAndView();
        Remark remark = new Remark();
        remark.setPostidTea(Integer.parseInt(postId));
        List<Remark> all = remarkService.findAll(remark);
        PostsTea byId = postsTeaService.findById(Integer.parseInt(postId));
        StuPost stuPost = new StuPost();
        stuPost.setStuId(byId.getTeacherid());
        stuPost.setTime(byId.getPostdate());
        stuPost.setContent(byId.getContent());
        stuPost.setPostId(byId.getPostid());
        Student byId1 = studentService.findById(byId.getTeacherid());
        stuPost.setStuName(byId1.getName());
        modelAndView.addObject("post",stuPost);
        List<StuRemark> remarks = new ArrayList<>();
        for (Remark re: all
        ) {
            StuRemark stuRemark = new StuRemark();
            stuRemark.setContent(re.getRemarkContext());
            stuRemark.setDate(re.getRemarkTime());
            stuRemark.setStuId(re.getStudentid());
            Teacher byId2 = teacherService.findById(re.getTeacherid());
            stuRemark.setName(byId2.getName());
            remarks.add(stuRemark);
        }
        modelAndView.addObject("remarks",remarks);
        modelAndView.setViewName("teaRemark");
        return modelAndView;
    }



}
