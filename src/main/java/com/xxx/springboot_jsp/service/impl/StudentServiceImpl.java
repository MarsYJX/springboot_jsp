package com.xxx.springboot_jsp.service.impl;


import com.xxx.springboot_jsp.mapper.StudentMapper;
import com.xxx.springboot_jsp.model.Student;
import com.xxx.springboot_jsp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(String username, String password) {
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        return studentMapper.login(student);
    }

    @Override
    public int register(String username, String password, String studentName, int parseInt) {
        Student student = new Student();
        student.setPassword(password);
        student.setUsername(username);
        student.setStudentName(studentName);
        student.setStudentId(parseInt);
        return this.studentMapper.register(student);
    }
}
