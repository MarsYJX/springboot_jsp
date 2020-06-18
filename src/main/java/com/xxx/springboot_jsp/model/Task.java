package com.xxx.springboot_jsp.model;


public class Task {

    private Integer id;
    private String taskName;
    private String taskContent;
    private String taskAnswer;
    /**
     * 学生名字
     */
    private String studentName;
    /**
     * 老师名字
     */
    private String teacherName;
    /**
     * 标记,0表示没有阅读,1表示阅读过
     */
    private Integer taskSign;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTaskAnswer() {
        return taskAnswer;
    }

    public void setTaskAnswer(String taskAnswer) {
        this.taskAnswer = taskAnswer;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskSign() {
        return taskSign;
    }

    public void setTaskSign(Integer taskSign) {
        this.taskSign = taskSign;
    }
}
