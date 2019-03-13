package com.canJ.controller;

import com.canJ.pojo.FocusStu;
import com.canJ.pojo.StuFocus;
import com.canJ.pojo.Student;
import com.canJ.service.FocusStuService;
import com.canJ.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生关注Controller
 */
@Controller
@RequestMapping("/focus/stu")
public class FocusStuController {

    @Autowired
    private FocusStuService focusStuService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private HttpSession session;

    @ResponseBody
    @RequestMapping("/focusStu")
    public String focusStu(Integer stuId){
        Student student =(Student) session.getAttribute("student");
        FocusStu focusStu = new FocusStu();
        focusStu.setStudentid(student.getStudentid());
        focusStu.setOtherstudentid(stuId);
        boolean b = focusStuService.focusStu(focusStu);
        if (b){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/findAllFocus")
    public ModelAndView findAll(){
        Student student =(Student) session.getAttribute("student");
        FocusStu focusStu = new FocusStu();
        focusStu.setStudentid(student.getStudentid());
        List<FocusStu> all = focusStuService.findAll(focusStu);
        ModelAndView modelAndView = new ModelAndView();
        List<StuFocus> foci = new ArrayList<>();
        for (FocusStu s: all
        ) {
            StuFocus stuFocus = new StuFocus();
            stuFocus.setStuId(s.getOtherstudentid());
            stuFocus.setFocusId(s.getFocusid());
            Student byId = studentService.findById(s.getOtherstudentid());
            stuFocus.setName(byId.getName());
            foci.add(stuFocus);
        }
        modelAndView.addObject("all",foci);
        modelAndView.setViewName("stuFocus");
        return modelAndView;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String focusId){
        boolean b = focusStuService.deleteById(Integer.parseInt(focusId));
        if (b){
            return "true";
        }
        return "false";
    }



}
