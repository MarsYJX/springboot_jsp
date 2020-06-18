package com.xxx.springboot_jsp.controller;

import com.xxx.springboot_jsp.model.Teacher;
import com.xxx.springboot_jsp.service.StudentService;
import com.xxx.springboot_jsp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class RegisterController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/doTeacherRegister")
    @ResponseBody
    public Map doTeacherRegister(HttpServletRequest request){
        String username = request.getParameter("t_username");
        String password = request.getParameter("t_password");
        String teacherName = request.getParameter("teacherName");
        String teacherId = request.getParameter("teacherId");
        //进行登陆校验
        int i = this.teacherService.register(username,password,teacherName,Integer.parseInt(teacherId));
        if (i>0){
            //登陆成功,将用户放在session域中
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
    /**
     *  "s_username": s_username,
     *   s_password": s_password,
     *   s_student_name": s_student_name,
     *   "s_student_id": s_student_id
     */
    @PostMapping("/doStudentRegister")
    @ResponseBody
    public Map doStudentRegister(HttpServletRequest request){
        String username = request.getParameter("s_username");
        String password = request.getParameter("s_password");
        String studentName = request.getParameter("s_student_name");
        String studentId = request.getParameter("s_student_id");
        //进行登陆校验
        int i = this.studentService.register(username,password,studentName,Integer.parseInt(studentId));
        if (i>0){
            //登陆成功,将用户放在session域中
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
