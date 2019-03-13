package com.canJ.controller;

import com.canJ.pojo.*;
import com.canJ.service.CourseService;
import com.canJ.service.StudentService;
import com.canJ.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程Controller
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private HttpSession session;

    @RequestMapping("/studentId")
    public ModelAndView findCourseByStuId(){
        Student student =(Student) session.getAttribute("student");
        List<Course> byStuId = courseService.findByStuId(student.getStudentid());
        List<StuCourse> courses = new ArrayList<>();
        for (Course course: byStuId
        ) {
            StuCourse stuCourse = new StuCourse();
            stuCourse.setCourName(course.getCourname());
            stuCourse.setCourNumber(course.getCournumber());
            stuCourse.setCourseCredit(course.getCourcredit());
            stuCourse.setGrade(course.getCourgrade());
            Teacher byId = teacherService.findById(course.getTeacherid());
            stuCourse.setTeaName(byId.getName());
            courses.add(stuCourse);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses",courses);
        modelAndView.setViewName("stuCourse");
        return modelAndView;
    }

    @RequestMapping("/teaCourse")
    public ModelAndView teaCourse(){
        Teacher teacher =(Teacher) session.getAttribute("teacher");
        List<TeaCourse> courses = new ArrayList<>();
        List<Course> allById = courseService.findAllById(teacher.getTeacherid());
        for (Course course: allById
        ) {
            TeaCourse teaCourse = new TeaCourse();
            teaCourse.setCourName(course.getCourname());
            teaCourse.setCourNumber(course.getCournumber());
            teaCourse.setGrade(course.getCourgrade());
            teaCourse.setStuId(course.getStudentid());
            teaCourse.setTeacherId(course.getTeacherid());
            teaCourse.setCourId(course.getCourid());
            Student byId = studentService.findById(course.getStudentid());
            teaCourse.setStuName(byId.getName());
            courses.add(teaCourse);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses",courses);
        modelAndView.setViewName("teaCourse");
        return modelAndView;
    }

    @RequestMapping("/teaUpdate")
    public ModelAndView teaUpdate(String courId,String grade){
        Course course1 = new Course();
        course1.setCourid(Integer.parseInt(courId));
        course1.setCourgrade(Integer.parseInt(grade));
        boolean b = courseService.teaCourse(course1);
        if (b){
            Teacher teacher =(Teacher) session.getAttribute("teacher");
            List<TeaCourse> courses = new ArrayList<>();
            List<Course> allById = courseService.findAllById(teacher.getTeacherid());
            for (Course course: allById
            ) {
                TeaCourse teaCourse = new TeaCourse();
                teaCourse.setCourName(course.getCourname());
                teaCourse.setCourNumber(course.getCournumber());
                teaCourse.setGrade(course.getCourgrade());
                teaCourse.setStuId(course.getStudentid());
                teaCourse.setTeacherId(course.getTeacherid());
                teaCourse.setCourId(course.getCourid());
                Student byId = studentService.findById(course.getStudentid());
                teaCourse.setStuName(byId.getName());
                courses.add(teaCourse);
            }
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("courses",courses);
            modelAndView.setViewName("teaCourse");
            return modelAndView;
        }else {
            return null;
        }
    }

}
