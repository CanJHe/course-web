package com.canJ.controller;

import com.canJ.pojo.Teacher;
import com.canJ.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 教师Controller
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private HttpSession session;


    private Logger logger= Logger.getLogger(TeacherController.class);

    @RequestMapping("/login")
    @ResponseBody
    public String login(Teacher teacher,
                        HttpServletRequest request,
                        HttpServletResponse response) throws UnsupportedEncodingException {
        boolean b = teacherService.teaLogin(teacher);
        String renumber = request.getParameter("renumber");
        if (b) {
            if ("记住密码".equals(renumber)) {
                Cookie cookie = new Cookie("tea_name", URLEncoder.encode(teacher.getName(), "UTF-8"));
                Cookie cookie2 = new Cookie("tea_pass", URLEncoder.encode(teacher.getPassword(), "UTF-8"));
                //设置生命周期
                cookie.setMaxAge(60 * 60 * 24 * 15);
                cookie2.setMaxAge(60 * 60 * 24 * 15);
                //添加到浏览器上
                response.addCookie(cookie);
                response.addCookie(cookie2);
            }
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    //设置这个参数是必须要传入的，否则就会报错,@RequestParam(value = "tea_phone"，required = true)注解中加入这个属性required
    public String register(Teacher teacher){
        logger.info(teacher.getTeaPhone());
        logger.info(teacher.getName());
        logger.info(teacher.getPassword());
        teacher.setTeState((short)1);
        boolean b = teacherService.teaRegister(teacher);
        if (b){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        /**
         * 退出就把session中的值去掉,然后重定向
         */
        session.removeAttribute("teacher");
        return "redirect:/skip/skip2";
    }

    @RequestMapping("/reset")
    public ModelAndView reset(Teacher teacher){
        ModelAndView modelAndView = new ModelAndView();
        logger.info(teacher.getTeaPhone());
        modelAndView.addObject("teaPhone",teacher.getTeaPhone());
        modelAndView.setViewName("teaResetPass");
        return modelAndView;
    }

    @RequestMapping("/resetPass")
    @ResponseBody
    public String resetPass(Teacher teacher){
        boolean b = teacherService.updateForget(teacher);
        if (b){
            return "true";
        }
        return "false";
    }


    @RequestMapping("/teaDetail")
    public ModelAndView teaDetail(){
        ModelAndView modelAndView = new ModelAndView();
        Teacher teacher =(Teacher) session.getAttribute("teacher");
        Teacher byId = teacherService.findById(teacher.getTeacherid());
        modelAndView.addObject("teacher",byId);
        modelAndView.setViewName("teaDetail");
        return modelAndView;
    }

    @RequestMapping("/updateSelf")
    public ModelAndView updateSelf(){
        Object teacher = session.getAttribute("teacher");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("teacher",teacher);
        modelAndView.setViewName("teaUpdate");
        return modelAndView;
    }

    @RequestMapping("/updateSelfs")
    public ModelAndView updateSelfs(Teacher teacher){
        ModelAndView modelAndView = new ModelAndView();
        boolean b = teacherService.update(teacher);
        if (b){
            Teacher byId = teacherService.findById(teacher.getTeacherid());
            session.setAttribute("teacher",byId);
            modelAndView.addObject("teacher",byId);
            modelAndView.setViewName("teaDetail");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping("/teaReset")
    public ModelAndView studentReset(){
        Teacher teacher =(Teacher) session.getAttribute("teacher");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stuPhone",teacher.getTeaPhone());
        modelAndView.setViewName("teaResetPass");
        return modelAndView;
    }

    @RequestMapping("/introduce")
    public ModelAndView introduce(Integer stuId){
        Teacher byId = teacherService.findById(stuId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("teacher",byId);
        modelAndView.setViewName("teaIntroduce");
        return modelAndView;
    }
}
