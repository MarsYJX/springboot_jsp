package com.xxx.springboot_jsp.service.impl;

import com.xxx.springboot_jsp.mapper.TaskMapper;
import com.xxx.springboot_jsp.model.Task;
import com.xxx.springboot_jsp.service.TaskServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServerImpl implements TaskServer {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> getTaskList() {
        return taskMapper.getTaskList();
    }

    @Override
    public int addTask(String taskName, String taskContent,String teacherName) {
        Task task = new Task();
        task.setTaskContent(taskContent);
        task.setTaskName(taskName);
        task.setTeacherName(teacherName);
        return this.taskMapper.addTask(task);
    }

    @Override
    public int completeTask(String taskAnswer, Integer taskId, String studentName) {
        Task task = new Task();
        task.setId(taskId);
        task.setTaskAnswer(taskAnswer);
        task.setStudentName(studentName);
        return this.taskMapper.completeTask(task);
    }

    @Override
    public int deleteTask(Integer id) {
        return this.taskMapper.deleteById(id);
    }
}
