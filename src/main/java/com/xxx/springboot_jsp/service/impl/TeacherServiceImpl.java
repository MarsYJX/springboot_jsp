package com.xxx.springboot_jsp.service.impl;

import com.xxx.springboot_jsp.mapper.TeacherMapper;
import com.xxx.springboot_jsp.model.Teacher;
import com.xxx.springboot_jsp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Teacher login(String username, String password) {
        Teacher teacher = new Teacher();
        teacher.setPassword(password);
        teacher.setUsername(username);
        return this.teacherMapper.login(teacher);
    }

    @Override
    public int register(String username, String password, String teacherName, Integer teacherId) {
        Teacher teacher = new Teacher();
        teacher.setUsername(username);
        teacher.setPassword(password);
        teacher.setTeacherName(teacherName);
        teacher.setTeacherId(teacherId);
        return this.teacherMapper.register(teacher);
    }
}
