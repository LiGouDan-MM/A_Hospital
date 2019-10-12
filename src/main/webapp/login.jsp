<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <link href="dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
    span{
       color:red;
    }
    </style>
</head>
<body>
<h1>这是3的啊小宝贝</h1>
<div class="container">
    <form class="form-signin" method="post" action="${pageContext.request.contextPath }/Login">
        <h2 class="form-signin-heading">&nbsp;&nbsp;&nbsp;登录系统</h2>
        <input type="text" id="i1" name="user_name" class="input-block-level" placeholder="账号">
        <input type="password" id="i2" name="password" class="input-block-level" placeholder="密码">
        <input type="text" name="verify" class="input-medium" placeholder="验证码">7236///////
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button id="d1"  class="btn btn-large btn-primary" type="submit">登录</button>
        <!-- <button type="button" class="btn btn-lg btn-primary" disabled="disabled">登录</button> -->
        </p>
        <span>${ErrMessage }</span>
    </form>

</div>
</body>
<script type="text/javascript" src="Js/jquery-1.11.0.js"></script>
<script type="text/javascript">
 var reg = /^[A-Z]{1}[a-z0-9]{5,9}$/;
 $("#i1").keyup(function(){
    	if (reg.test($("#i1").val())){
    		 $("#d1").removeAttr("disabled");
    		 $("#s1").remove();
        	 $("#i1").after("<span id='s1'>符合规则</span>");
        	 $("#s1").css("color","green");
    	}else{
    		 $("#s1").remove();
       	     $("#i1").after("<span id='s1'>不符合规则</span>");
       	     $("#d1").attr("disabled","disabled");
       	     $("#s1").css("color","red");
    	}
    });
</script>
</html>