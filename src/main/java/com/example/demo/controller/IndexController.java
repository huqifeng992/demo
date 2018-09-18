package com.example.demo.controller;

import com.example.demo.ExcelModel.StudentEntity;
import com.example.demo.restful.GlobalResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by huqifeng on 2017/11/21 9:52.
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    @ResponseBody
    public Object hello() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId("1");
        studentEntity.setName("huqifeng");
        studentEntity.setSex(2);
        studentEntity.setBirthday(new Date());
        return GlobalResponse.success(studentEntity);
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("+++++++++++++++++++++进入到了index方法中了！+++++++++++++++++++++");
        return "index";
    }

    @RequestMapping("/index1")
    public ModelAndView index1() {
        ModelAndView mav = new ModelAndView("index");
        System.out.println("+++++++++++++++++++++进入到了index1方法中了！+++++++++++++++++++++");
        return mav;
    }

}
