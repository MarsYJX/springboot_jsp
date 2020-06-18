<%--
  Created by IntelliJ IDEA.
  User: Listen
  Date: 2020/6/15
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布作业</title>
    <link href="favicon.ico" rel="shortcut icon"/>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://www.jq22.com/jquery/jquery-2.1.1.js"></script>
</head>
<body>
<div style="width: 800px;margin: auto auto;height: 500px; margin-top: 100px;">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label class="col-sm-2 control-label">作业名称</label>
            <div class="col-sm-10">
                <input id="taskName" type="text" class="form-control" placeholder="请输入作业名称">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">作业描述</label>
            <div class="col-sm-10">
                <textarea id="taskContent" class="form-control" rows="3"></textarea>
            </div>
        </div>
        <div class="col-sm-offset-2 col-sm-10">
            <button onclick="addTask()" type="button" class="btn btn-default">提交</button>
        </div>
        <div class="col-sm-offset-2 col-sm-10">
            <button onclick=" goBack()" type="button" class="btn btn-default">返回</button>
        </div>
    </form>
</div>
</body>
</html>
<script type="text/javascript">
    function addTask() {
        var taskName = $("#taskName").val();
        var taskContent = $("#taskContent").val();
        console.log(taskContent+taskName)
        //提交表单
        //提交表单
        $.ajax({
            url: "${pageContext.request.contextPath}/addTask",
            type: "post",
            data: {"taskName": taskName, "taskContent": taskContent},
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

    }
    function goBack() {
        window.location.href = "teacher_home"
    }
</script>
