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
            <label class="col-sm-2 control-label">作业答案</label>
            <div class="col-sm-10">
                <textarea id="taskAnswer" class="form-control" rows="3"></textarea>
            </div>
        </div>
        <div class="col-sm-offset-2 col-sm-10">
            <button onclick="completeTask()" type="button" class="btn btn-default">提交</button>
        </div>
        <div class="col-sm-offset-2 col-sm-10">
            <button onclick=" goBack()" type="button" class="btn btn-default">返回</button>
        </div>
    </form>
</div>
</body>
</html>
<script type="text/javascript">

    (function ($) {
        $.getUrlParam = function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            //获取参数
            if (r != null) return unescape(r[2]);
            //为空
            return null;
        }
    })(jQuery);

    function completeTask() {
        //原生js获取地址栏参数
        // var query = window.location.search.substring(1);
        // var vars = query.split("=");
        // console.log(urlParam+"====")
        // for (var i = 0; i < vars.length; i++) {
        //     console.log(vars[i].toString())
        // }
        //JQ获取地址栏参数
        var taskId = $.getUrlParam('taskId');
        var taskAnswer = $("#taskAnswer").val();
        if (taskId==null&&taskId==""){
            alert("作业ID不能为空")
        }
        if (taskAnswer==null&&taskAnswer==""){
            alert("作业答案不能为空")
        }
        // console.log(taskContent+taskName+"ssss"+s)
        //提交表单
        $.ajax({
            url: "${pageContext.request.contextPath}/completeTask",
            type: "post",
            data: {"taskId":taskId,"taskAnswer": taskAnswer},
            success: function (result) {
                console.log(result.code)
                if (result.code == 200) {
                    window.location.href = "student_home";
                    //toIndex();
                } else {
                    alert(result.msg)
                }
            }
        });

    }

    function goBack() {
        window.location.href = "student_home"
    }
</script>
