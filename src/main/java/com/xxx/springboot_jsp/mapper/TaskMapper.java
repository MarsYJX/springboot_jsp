package com.xxx.springboot_jsp.mapper;

import com.xxx.springboot_jsp.model.Student;
import com.xxx.springboot_jsp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface TaskMapper {

    /**
     * 查询所有作业
     * @return  List<Task>
     */
    List<Task> getTaskList();

    /**
     * 添加
     * @param task 作业
     * @return int
     */
    int addTask(Task task);

    /**
     * 学生提交作业
     * @param task task
     * @return int
     */
    int completeTask(Task task);

    /**
     * 删除
     * @param id id
     * @return  int
     */
    int deleteById(Integer id);
}
