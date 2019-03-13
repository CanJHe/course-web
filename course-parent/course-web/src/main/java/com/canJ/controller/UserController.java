package com.canJ.controller;

import com.canJ.pojo.ResponseJson;
import com.canJ.pojo.Student;
import com.canJ.pojo.User;
import com.canJ.service.UserService;
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
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @Autowired
    private HttpSession session;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/register")
    @ResponseBody
    public String addUser(User user){
        boolean b = userService.addUser(user);
        if(b){
            return "true";
        }else{
            return "false";
        }
    }

    @RequestMapping("/adlogin")
    public String login(User user){
        User u = userService.loginUser(user);
        if (u != null){
            /**
             *先让session失效，然后再设置session中的值
             */
            session.invalidate();
            session.setAttribute("user",u);
            return "adminDetail";
        }else {
            return "index";
        }
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
      session.removeAttribute("user");
      return "redirect:/skip/skip2";
    }

    @ResponseBody
    @RequestMapping("/forget")
    public ResponseJson forget(User user){
        ResponseJson responseJson = new ResponseJson();
        boolean byPhone = userService.findByPhone(user);
        if (byPhone){
            responseJson.setFlag("true");
            responseJson.setMessage(user.getUserPhone());
            return responseJson;
        }else {
            responseJson.setFlag("false");
            return responseJson;
        }
    }

    @RequestMapping("/reset")
    public ModelAndView reset(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adResetPass");
        return modelAndView;
    }

    @RequestMapping("/resetPass")
    @ResponseBody
    public String resetPass(User user){
        logger.info(user.getUserPhone());
        boolean b = userService.updateUserByPhone(user);
        if (b){
            return "true";
        }
        return "false";
    }

    /**
     * 查看管理员详细信息
     * @return
     */
    @RequestMapping("/userDetail")
    public String userDetail(){
        return "adminDetail";
    }


    /**
     * 跳转到管理员修改信息页面
     * @param user
     * @return
     */
    @RequestMapping("/updateInfoPrompt")
    public String updateInfoPrompt(User user){
      return "admUpdate";
    }

    /**
     * 修改管理员信息
     * @return
     */
    @RequestMapping("/updateInfo")
    public String updateInfo(User user){
        boolean result = userService.updateUserById(user);
        if (result){
            return "adminDetail";
        }
       return "error/error";
    }


    /**
     * 返回添加学生页面
     * @return
     */
    @RequestMapping("/addStudentPrompt")
    public String addStudentPrompt(){
        return "addStu";
    }

    /**
     * 添加学生
     * @return
     */
    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(Student student){
        boolean result = userService.addStudent(student);
        if (result){
            return "true";
        }
        return "false";
    }

    /**
     * 转发到修改学生信息页面
     * @return
     */
    @RequestMapping("/updateStudentPrompt/{studentid}")
    public String updateStudentPrompt(@PathVariable  int studentid ,Model model){
        Student student = userService.findStudentById(studentid);
        model.addAttribute("student",student);
        return "stuUpdateByUser";
    }

    /**
     * 修改学生信息
     * @return
     */
    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
        boolean result = userService.updateStudent(student);
        if (result){
            return "redirect:students";
        }
        return "error/error";
    }

    /**
     * 删除学生
     * @return
     */
    @RequestMapping("/deleteStudent/{studentid}")
    public String deleteStudent(@PathVariable int studentid){
        boolean result = userService.deleteStudent(studentid);
        if (result){
            return "redirect:/user/students";
        }
        return "error/error";
    }

    /**
     * 查询所有学生
     * @return
     */
    @RequestMapping("/students")
    public String selectStudents(Model model){
        List<Student> students = userService.selectStudents();
        model.addAttribute("students",students);
        return "showStudents";
    }

    /**
     * 禁言学生
     * @param studentid
     * @return
     */
    @RequestMapping("/forbitStudent/{studentid}")
    public String forbitStudent(@PathVariable int studentid){
        boolean result = userService.forbitStudent(studentid);
        if (result){
            return "redirect:/posts/stu/allPost";
        }
        return "error/error";
    }

    /**
     * 取消禁言
     * @param studentid
     * @return
     */
    @RequestMapping("/cancelForbitStudent/{studentid}")
    public String cancelForbitStudent(@PathVariable int studentid){
        boolean result = userService.cancelForbitStudent(studentid);
        if (result){
            return "redirect:/posts/stu/allPost";
        }
        return "error/error";
    }




}
