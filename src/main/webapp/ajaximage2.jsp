<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--éè¿new form è¡¨åå¯¹è±¡,ä»è¡¨åå¯¹è±¡ä¸­è·å¾ä¸ä¼ çæä»¶å¯¹è±¡
    å°è¿ä¸ªå¯¹è±¡éè¿ajaxåéå°åå°
-->
<form action="#" id="formId" >
       <input type="file" name="img"><br>
       <input type="button" value="上传" onclick="doupload();"><br>
       <input type="hidden" id="hidden" name="file_id" value="">
       <br>
       <br>
       <input type="button" value="下载" onclick="doDownLoad();">
       <br>
       <input type="button" value="更新" onclick="doUpdate();">
</form>

<div>
    <img id="i1" width="500px" height="500px" src="">
    
</div>


</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery-1.11.0.js"></script>
<script type="text/javascript">
    function doupload(){
    	var formData = new FormData($("#formId")[0]);
    	$.ajax({
    		url:"Check/Upload2",
    		type:"POST",
    		data:formData,
    		//async:false,
    		processData: false,
            contentType: false,
    		success:function(data){
    			alert(data.path);
    			alert(data.file_id);
    			$("#i1").attr("src",data.path);
    			$("#hidden").attr("value",data.file_id);
    		}
    	});
    };
    
    
    function doDownLoad(){
    	var path = $("#hidden").val();
    	alert(path);
    	$.ajax({
    		url:"Check/DownLoad",
    		data:{"file_Id":path},
    		type:"POST",
    		success:function(data){
    			alert(data.obj+"哈哈");
    		    
    		}
    	});
    };
    
    
    
    function doUpdate(){
    	var path = $("#hidden").val();
    	alert(path);
    	$.ajax({
    		url:"Check/UpdateDelete",
    		data:{"file_Id":path},
    		type:"POST",
    		success:function(data){
    			alert(data.obj+"哈哈");
    		    
    		}
    	});
    };  
</script>
</html>