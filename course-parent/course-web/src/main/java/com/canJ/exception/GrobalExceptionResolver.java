package com.canJ.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GrobalExceptionResolver implements HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(GrobalExceptionResolver.class);



    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        logger.info("进入全局异常处理器");

        logger.error("系统异常",e);
        //返回错误页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","系统出现异常，请稍后再试");
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}
