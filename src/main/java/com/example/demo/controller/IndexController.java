package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huqifeng on 2017/11/21 9:52.
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("+++++++++++++++++++++进入到了hello方法中了！+++++++++++++++++++++");
        return "hello";
    }

    @RequestMapping("/index")
    public String index(){
        System.out.println("+++++++++++++++++++++进入到了index方法中了！+++++++++++++++++++++");
        return "index";
    }

    @RequestMapping("/index1")
    public ModelAndView index1(){
        ModelAndView mav = new ModelAndView("index");
        System.out.println("+++++++++++++++++++++进入到了index1方法中了！+++++++++++++++++++++");
        return mav;
    }

}
