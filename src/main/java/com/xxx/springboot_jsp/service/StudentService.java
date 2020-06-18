package com.xxx.springboot_jsp.service;

import com.xxx.springboot_jsp.model.Student;

public interface StudentService {
    /**
     * 登陆方法
     * @param username 用户名
     * @param password 密码
     * @return 学生对象
     */
    Student login(String username, String password);

    /**
     * 学生注册
     * @param username 学生账号
     * @param password 学生密码
     * @param studentName 学生名称
     * @param parseInt 学生学号
     * @return int
     */
    int register(String username, String password, String studentName, int parseInt);
}
