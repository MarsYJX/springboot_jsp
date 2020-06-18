package com.xxx.springboot_jsp.mapper;

import com.xxx.springboot_jsp.model.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentMapper {

    /**
     * 更具用户名,密码查询学生
     * @param student 学生对象
     * @return 学生对象
     */
    Student login(Student student);

    /**
     * 学生注册
     * @param student student
     * @return int
     */
    int register(Student student);
}
