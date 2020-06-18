<%--
  Created by IntelliJ IDEA.
  User: Listen
  Date: 2020/6/15
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://www.jq22.com/jquery/jquery-2.1.1.js"></script>
</head>
<body>
<div id="" style="margin: auto auto; height: 50px;width: 800px;margin-top: 50px; display: flex;flex-direction: row;justify-content:space-evenly ;">
    <button type="button" class="btn btn-success">作业列表</button>
    <button type="button" class="btn btn-success" onclick="toAddTask()">发布作业</button>
</div>
<div style="width: 1200px;margin: auto;margin-top: 50px;">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>作业编号</th>
            <th>作业名称</th>
            <th>作业内容</th>
            <th>提交答案</th>
            <th>提交学生名字</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.tasks}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.taskName}</td>
                <td>${list.taskContent}</td>
                <td>${list.taskAnswer}</td>
                <td>${list.studentName}</td>
                <td>
                    <button type="button" onclick="deleteTask(${list.id})"  class="btn btn-danger">删除作业</button>
                    <button type="button" onclick="updateTask(${list.id})" class="btn btn-info">修改作业</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
<script type="text/javascript">
    function toAddTask() {
        window.location.href="teacher_add_task"
    }
    function deleteTask(taskId) {
        console.log(taskId)
        //提交表单
        $.ajax({
            url: "${pageContext.request.contextPath}/deleteTask/"+taskId,
            type: "get",
            success: function (result) {
                console.log(result.code)
                if (result.code == 200) {
                    window.location.href = "teacher_home";
                    //toIndex();
                } else {
                    alert(result.msg)
                }
            }
        });
        // alert("该功能暂未实现!")
    }
    function updateTask(taskId) {
        console.log(taskId)
        alert("该功能暂未实现!")
    }
</script>
