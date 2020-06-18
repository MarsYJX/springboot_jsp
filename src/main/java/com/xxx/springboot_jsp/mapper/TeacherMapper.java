package com.xxx.springboot_jsp.mapper;

import com.xxx.springboot_jsp.model.Student;
import com.xxx.springboot_jsp.model.Teacher;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherMapper {

    /**
     * 更具用户名,密码查询学生
     * @param teacher teacher
     * @return teacher
     */
    Teacher login(Teacher teacher);

    /**
     * 注册
     * @param teacher 老师对象
     * @return int
     */
    int register(Teacher teacher);
}
