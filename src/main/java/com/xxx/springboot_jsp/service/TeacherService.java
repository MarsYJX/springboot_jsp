package com.xxx.springboot_jsp.service;

import com.xxx.springboot_jsp.model.Teacher;


public interface TeacherService {

    /**
     * 老师登陆
     * @param username 用户名
     * @param password 密码
     * @return Teacher
     */
    Teacher login(String username, String password);

    /**
     * 老师注册
     * @param username 账号
     * @param password 密码
     * @param teacherName 老师名字
     * @param teacherId 老师编号
     * @return int
     */
    int register(String username, String password, String teacherName, Integer teacherId);
}
