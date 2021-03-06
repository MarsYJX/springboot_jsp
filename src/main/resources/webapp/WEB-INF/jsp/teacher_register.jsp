<%--
  Created by IntelliJ IDEA.
  User: Listen
  Date: 2020/6/15
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>love</title>
    <link href="favicon.ico" rel="shortcut icon" />
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://www.jq22.com/jquery/jquery-2.1.1.js"></script>
</head>
<body style=" background: url(http://global.bing.com/az/hprichbg/rb/RavenWolf_EN-US4433795745_1920x1080.jpg) no-repeat center center fixed; background-size: 100%;">


<div class="modal-dialog" style="margin-top: 10%;">
    <div class="modal-content">
        <div class="modal-header">

            <h4 class="modal-title text-center" id="myModalLabel">老师注册</h4>
        </div>
        <div class="modal-body" id = "model-body">
            <div class="form-group">

                <input type="text" id="t_username" class="form-control"placeholder="用户名" autocomplete="off">
            </div>
            <div class="form-group">

                <input type="password" id="t_password" class="form-control" placeholder="密码" autocomplete="off">
            </div>
            <div class="form-group">

                <input type="text" id="teacherName" class="form-control" placeholder="姓名" autocomplete="off">
            </div>
            <div class="form-group">
                <input type="text" id="teacherId" class="form-control" placeholder="编号" autocomplete="off">
            </div>
        </div>
        <div class="modal-footer">
            <div class="form-group">
                <button type="button" onclick="doTeacherRegister()"  class="btn btn-primary form-control">注册</button>
            </div>
        </div>
    </div><!-- /.modal-content -->
</div><!-- /.modal -->

</body>
</html>
<script type="text/javascript">
    function doTeacherRegister() {
        var t_username = $("#t_username").val();
        var t_password = $("#t_password").val();
        var teacherName = $("#teacherName").val();
        var teacherId = $("#teacherId").val();
        // console.log(t_password+'<===>'+t_username)
        if (t_username==""){
            alert("用户名不能为空")
            return;
        }
        if (t_password==""){
            alert("密码不能为空")
            return;
        }
        if (teacherName==""){
            alert("老师的名字不能为空")
            return;
        }
        if (teacherId==""){
            alert("老的的编号不能为空")
            return;
        }
        //提交表单
        $.ajax({
            url: "${pageContext.request.contextPath}/doTeacherRegister",
            type: "post",
            data: {
                "t_username": t_username,
                "t_password": t_password,
                "teacherName": teacherName,
                "teacherId": teacherId
            },
            success: function (result) {
                console.log(result.code)
                if (result.code == 200) {
                    window.location.href = "teacher_login";
                    //toIndex();
                } else {
                    alert(result.msg)
                }
            }
        });

    }
</script>
