package com.xxx.springboot_jsp.controller;

import com.xxx.springboot_jsp.model.Task;
import com.xxx.springboot_jsp.service.TaskServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController {


    @Autowired
    private TaskServer taskServer;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/teacher_add_task",method = RequestMethod.GET)
    public String teacherAddTask() {
        return "teacher_add_task";
    }

    @RequestMapping(value = "/student_complete_task",method = RequestMethod.GET)
    public String studentCompleteTask() {
        return "student_complete_task";
    }

    @RequestMapping(value = "/teacher_home",method = RequestMethod.GET)
    public String teacherHome(HttpServletRequest request) {
        //将数据放在作用域中
        List<Task> tasks =  this.taskServer.getTaskList();
//        System.out.println("tasks"+tasks);
//        tasks.forEach(e->{
//            System.out.println(e.getId());
//        });
        request.setAttribute("tasks",tasks);
        return "teacher_home";
    }
    @RequestMapping(value = "/student_home",method = RequestMethod.GET)
    public String studentHome(HttpServletRequest request) {
        List<Task> tasks = this.taskServer.getTaskList();
        request.setAttribute("tasks",tasks);
        return "student_home";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/student_login",method = RequestMethod.GET)
    public String studentLogin() {
        return "student_login";
    }
    @RequestMapping(value = "/student_register",method = RequestMethod.GET)
    public String studentRegister() {
        return "student_register";
    }
    @RequestMapping(value = "/teacher_login",method = RequestMethod.GET)
    public String teacherLogin() {
        return "teacher_login";
    }
    @RequestMapping(value = "/teacher_register",method = RequestMethod.GET)
    public String teacherRegister() {
        return "teacher_register";
    }
}
