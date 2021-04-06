package com.zhoubw.controller;

import com.zhoubw.pojo.StudentEntity;
import com.zhoubw.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
@Slf4j
public class MyController {

    @Autowired
    MyService myService;



    @RequestMapping({"/index","/"})
    public String index(Model model){
        model.addAttribute("msg","spring");
        myService.test();
        StudentEntity student=myService.getStudent(1);
        log.info(student.toString());
        return "index";
    }

    @RequestMapping({"/login"})
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/calendar")
    public String calendar(){
        log.info("calendar");
        return "calendar";
    }

    @RequestMapping("/*")
    public String other(HttpServletRequest request,Model model){
        String url=request.getServletPath().substring(1);
         log.info(url.toString());
        model.addAttribute("url",url);
        return url;
    }


}
