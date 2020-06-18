package com.xxx.springboot_jsp.controller;

import com.xxx.springboot_jsp.model.Student;
import com.xxx.springboot_jsp.model.Teacher;
import com.xxx.springboot_jsp.service.StudentService;
import com.xxx.springboot_jsp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/doStudentLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map  doStudentLogin(HttpServletRequest request,HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+"<====>"+password);
        //进行登陆校验
        Student student = this.studentService.login(username,password);
        System.out.println(student);
        if (student!=null){
            //登陆成功,将用户放在session域中
            session.setAttribute("student",student);
            Map<Object, Object> map = new HashMap<>(4);
            map.put("code","200");
            map.put("msg","登陆成功");
            return map;
        }else {
            Map<String, Object> map = new HashMap<>(2);
            map.put("code","100");
            map.put("msg","登陆失败,账号或密码错误!");
            return map;
        }

    }

    @RequestMapping(value = "/doTeacherLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map doTeacherLogin(HttpServletRequest request,HttpSession session) throws IOException {
        String username = request.getParameter("t_username");
        String password = request.getParameter("t_password");
        System.out.println(username+"<====>"+password);
        //进行登陆校验
        Teacher teacher = this.teacherService.login(username,password);
        System.out.println(teacher);
        if (teacher!=null){
            //登陆成功,将用户放在session域中
            session.setAttribute("teacher",teacher);
            Map<String, Object> map = new HashMap<>(4);
            map.put("code","200");
            map.put("msg","登陆成功");
            return map;
        }else {
            Map<String, Object> map = new HashMap<>(4);
            map.put("code","100");
            map.put("msg","登陆失败,账号或密码错误!");
            return map;
        }
    }
}
