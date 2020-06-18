package com.xxx.springboot_jsp.controller;

import com.xxx.springboot_jsp.model.Student;
import com.xxx.springboot_jsp.model.Teacher;
import com.xxx.springboot_jsp.service.TaskServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;



@Controller
public class TaskController {

    @Autowired
    private TaskServer taskServer;


    /**
     * 老师发布作业
     * @param request request
     * @param session session
     * @return map
     */
    @RequestMapping(value = "/addTask",method = RequestMethod.POST)
    @ResponseBody
    public Map addTask(HttpServletRequest request, HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        System.out.println(teacher.getId()+teacher.getTeacherName());
        String taskName = request.getParameter("taskName");
        String taskContent = request.getParameter("taskContent");
        int i = this.taskServer.addTask(taskName,taskContent,teacher.getTeacherName());
//        System.out.println(i);
        if (i>0){
            Map<Object, Object> map = new HashMap<>(4);
            map.put("code","200");
            map.put("msg","添加成功");
            return map;
        }else {
            Map<Object, Object> map = new HashMap<>(4);
            map.put("code","100");
            map.put("msg","添加失败");
            return map;
        }
    }


    /**
     * 老师删除作业
     * @return map
     */
    @RequestMapping(value = "/deleteTask/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map deleteTaskById(@PathVariable("id") Integer id) {

        int i = this.taskServer.deleteTask(id);
//        System.out.println(i);
        if (i>0){
            Map<Object, Object> map = new HashMap<>(4);
            map.put("code","200");
            map.put("msg","添加成功");
            return map;
        }else {
            Map<Object, Object> map = new HashMap<>(4);
            map.put("code","100");
            map.put("msg","添加失败");
            return map;
        }
    }




    /**
     * 学生提交作业
     * @param request request
     * @param session session
     * @return map
     */
    @RequestMapping(value = "/completeTask",method = RequestMethod.POST)
    @ResponseBody
    public Map completeTask(HttpServletRequest request, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        System.out.println(student.getId()+student.getStudentName());
        String taskAnswer = request.getParameter("taskAnswer");
        String taskId = request.getParameter("taskId");
        int i = this.taskServer.completeTask(taskAnswer,Integer.parseInt(taskId),student.getStudentName());
//        System.out.println(i);
        if (i>0){
            Map<Object, Object> map = new HashMap<>(4);
            map.put("code","200");
            map.put("msg","添加成功");
            return map;
        }else {
            Map<Object, Object> map = new HashMap<>(4);
            map.put("code","100");
            map.put("msg","添加失败");
            return map;
        }
    }



}
