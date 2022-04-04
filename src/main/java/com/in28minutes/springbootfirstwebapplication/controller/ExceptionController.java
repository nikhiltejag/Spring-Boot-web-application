package com.in28minutes.springbootfirstwebapplication.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest request, Exception ex) {

        ModelAndView mv = new ModelAndView();

        mv.addObject("url", request.getRequestURI());
        mv.addObject("exception", ex);
        mv.setViewName("error");

        return mv;
    }
}
