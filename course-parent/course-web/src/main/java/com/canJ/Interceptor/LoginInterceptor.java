package com.canJ.Interceptor;

import com.canJ.pojo.Student;
import com.canJ.pojo.Teacher;
import com.canJ.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    private String[] allowUrls;


    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String requestUrl = httpServletRequest.getRequestURI().replace(httpServletRequest.getContextPath(), "");

        if (allowUrls != null && allowUrls.length >= 1){
            for (String s: allowUrls
            ) {
                if (requestUrl.contains(s)){
                    return true;
                }
            }
        }

        Teacher teacher = (Teacher) session.getAttribute("teacher");
        Student student = (Student) session.getAttribute("student");
        User user = (User) session.getAttribute("user");
        if (teacher!= null || student != null || user != null ){
            return true;
        }
        System.out.println("aaaa");
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
