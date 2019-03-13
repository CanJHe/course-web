package com.canJ.controller;

import com.canJ.pojo.Student;
import com.canJ.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * 学生Controller
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private HttpSession session;

    Logger logger = Logger.getLogger(StudentController.class);



    @RequestMapping("/stuLogin")
    @ResponseBody
    /**
     * 要注意，在springmvc的数据绑定中，如果遇到绑定的数据有可能为空时
     * 不要直接传给形参不然会报错，像下面的记住密码，就要在下面单独的取出来
     */
    public String login(Student student,
                        HttpServletResponse response,
                        HttpServletRequest request
    ) throws UnsupportedEncodingException {

        boolean b = studentService.stuLogin(student);
        String renumber = request.getParameter("renumber");
        if (b){
            /**
             * 判断是否勾选上记住密码
             * 要注意的是，cookie会出现编码问题
             * 如果要报错的字符串中含有中文的话
             * 就要设置编码，否则就要gg
             */
            if ("记住密码".equals(renumber)){
                Cookie cookie = new Cookie("stu_name", URLEncoder.encode(student.getName(), "UTF-8"));
                Cookie cookie1 = new Cookie("stu_password",URLEncoder.encode(student.getPassword(), "UTF-8"));
                //保存的有效期为一年
                cookie.setMaxAge(60*60*24*14);
                cookie1.setMaxAge(60*60*24*14);
                //把它添加进去
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
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
        session.removeAttribute("student");
        return "redirect:/skip/skip2";
    }


    @ResponseBody
    @RequestMapping("/forget")
    public String forgetPass(Student student, RedirectAttributes redirectAttributes){
        boolean forget = studentService.forget(student);
        if (forget){
            redirectAttributes.addFlashAttribute("stu_phone",student.getStuPhone());
            return "true";
        }else {
            return "false";
        }
    }

    @RequestMapping("/reset")
    @ResponseBody
    public String resetPass(Student student){

        logger.info("###############" + student.getPassword());

        boolean reset = studentService.reset(student);

        if (reset){
            return "true";
        }else {
            return "false";
        }
    }

    @RequestMapping("/stuDetail")
    public ModelAndView studentDetail(){
        Student student =(Student) session.getAttribute("student");
        ModelAndView view = new ModelAndView();
        view.addObject("student",student);
        view.setViewName("StuDetail");
        return view;
    }

    @RequestMapping("/stuReset")
    public ModelAndView studentReset(){
        Student student =(Student) session.getAttribute("student");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stuPhone",student.getStuPhone());
        modelAndView.setViewName("stuResetPass");
        return modelAndView;
    }

    @RequestMapping("/updateSelf")
    public ModelAndView updateSelf(){
        Student student =(Student)session.getAttribute("student");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student",student);
        modelAndView.setViewName("stuUpdate");
        return modelAndView;
    }

    @RequestMapping("/updateSelfs")
    public ModelAndView updateSelfs(Student student){
        ModelAndView modelAndView = new ModelAndView();
        boolean b = studentService.updateStudent(student);
        if (b){
            Student byId = studentService.findById(student.getStudentid());
            session.setAttribute("student",byId);
            modelAndView.addObject("student",byId);
            modelAndView.setViewName("StuDetail");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping("/introduce")
    public ModelAndView introduce(Integer stuId){
        Student byId = studentService.findById(stuId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student",byId);
        modelAndView.setViewName("stuIntroduce");
        return modelAndView;
    }

    @RequestMapping("/findStudent")
    public String findStudent(String name, Model model){
        List<Student> students = studentService.findStudentByNameOrClass(name);
        model.addAttribute("students",students);
        return "showStudents";
    }
}
