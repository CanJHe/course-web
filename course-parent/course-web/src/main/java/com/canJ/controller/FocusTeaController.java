package com.canJ.controller;

import com.canJ.pojo.FocusTea;
import com.canJ.pojo.StuFocus;
import com.canJ.pojo.Teacher;
import com.canJ.service.FocusTeaService;
import com.canJ.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 教师关注Controller
 */
@Controller
@RequestMapping("/focus/tea")
public class FocusTeaController {

    @Autowired
    private FocusTeaService focusTeaService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private HttpSession session;

    @RequestMapping("/findAllFocus")
    public ModelAndView findAll(){
        Teacher teacher =(Teacher) session.getAttribute("teacher");
        FocusTea focusTea = new FocusTea();
        focusTea.setTeacherid(teacher.getTeacherid());
        List<FocusTea> all = focusTeaService.findAll(focusTea);
        ModelAndView modelAndView = new ModelAndView();
        List<StuFocus> foci = new ArrayList<>();
        for (FocusTea s: all
        ) {
            StuFocus stuFocus = new StuFocus();
            stuFocus.setStuId(s.getOtherteacherid());
            stuFocus.setFocusId(s.getFocusid());
            Teacher byId = teacherService.findById(s.getOtherteacherid());
            stuFocus.setName(byId.getName());
            foci.add(stuFocus);
        }
        modelAndView.addObject("all",foci);
        modelAndView.setViewName("teaFocus");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/focusTea")
    public String focusStu(Integer teacherid){
        Teacher teacher =(Teacher) session.getAttribute("teacher");
        FocusTea focusTea = new FocusTea();
        focusTea.setTeacherid(teacher.getTeacherid());
        focusTea.setOtherteacherid(teacherid);
        boolean b = focusTeaService.focusTea(focusTea);
        if (b){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String focusId){
        boolean b = focusTeaService.deleteById(Integer.parseInt(focusId));
        if (b){
            return "true";
        }
        return "false";
    }


}
