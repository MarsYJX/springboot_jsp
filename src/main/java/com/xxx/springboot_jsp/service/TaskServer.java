package com.xxx.springboot_jsp.service;

import com.xxx.springboot_jsp.model.Task;

import java.util.List;


public interface TaskServer {
    /**
     * 获取作业列表
     * @return List<Task>
     */
    List<Task> getTaskList();

    /**
     * 添加作业
     * @param taskName 作业名
     * @param taskContent 作业简介
     * @param teacherName 作业发布者
     * @return int
     */
    int addTask(String taskName, String taskContent, String teacherName);

    /**
     * 学生体检作业
     * @param taskAnswer 作业答案
     * @param taskId 作业ID
     * @param studentName 作业名字
     * @return int
     */
    int completeTask(String taskAnswer, Integer taskId, String studentName);

    /**
     * 删除作业
     * @param id id
     * @return int
     */
    int deleteTask(Integer id);
}
