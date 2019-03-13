package com.canJ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面转发controller
 */
@Controller
@RequestMapping("/skip")
public class SkipController {

    /**
     * 管理员登录页面
     * @return
     */
    @RequestMapping("/skip1")
    public String skip1(){
        return "adminLogin";
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping("/skip2")
    public String skip2(){
        return "index";
    }

    /**
     * 教师登录界面
     * @return
     */
    @RequestMapping("/skip3")
    public String skip3(){
        return "teaLogin";
    }

    /**
     * 管理员注册界面
     * @return
     */
    @RequestMapping("/skipAdminRegister")
    public String skip4(){
        return "adRegister";
    }

    /**
     * 教师注册界面
     * @return
     */
    @RequestMapping("/skipTeaRegister")
    public String skip5(){
        return "teaRegister";
    }

    /**
     * 教师忘记密码界面
     * @return
     */
    @RequestMapping("/skipTeaForgetPass")
    public String skip6(){
        return "teaForgetPass";
    }

    /**
     * 教师重置密码界面
     * @return
     */
    @RequestMapping("/skipTeaResetPass")
    public String skip7(){
        return "teaResetPass";
    }

    /**
     * 重置成功界面
     * @return
     */
    @RequestMapping("/skipResetSuccess")
    public String skip8(){
        return "resetSuccess";
    }

    /**
     * 成功界面
     * @return
     */
    @RequestMapping("/success")
    public String skip9(){
        return "success/success";
    }

    /**
     * 学生忘记密码界面
     * @return
     */
    @RequestMapping("/stuForgetPass")
    public String skip10(){
        return "stuForgetPass";
    }

    /**
     * 学生重置密码界面
     * @return
     */
    @RequestMapping("/stuResetPass")
    public String skip11(){
        return "stuResetPass";
    }

    /**
     * 管理员忘记密码界面
     * @return
     */
    @RequestMapping("/adForgetPass")
    public String skip12(){
        return "adForgetPass";
    }

    /**
     * 管理员重置密码界面
     * @return
     */
    @RequestMapping("/adResetPass")
    public String skip13(){
        return "adResetPass";
    }
}

