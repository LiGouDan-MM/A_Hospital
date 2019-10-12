<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="#" id="formId">
       <input type="file" name="img"><br>
       <input type="button" value="上传" onclick="doupload();">
</form>
<div>
    <img id="i1" width="500px" height="500px" src="">
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery-1.11.0.js"></script>
<script type="text/javascript">
    function doupload(){
    	var formData = new FormData($("#formId")[0]);
    	alert(formData);
    	$.ajax({
    		url:"Check/Upload",
    		type:"POST",
    		data:formData,
    		//async:false,
    		processData: false,
            contentType: false,
    		success:function(data){
    			alert(data.obj);
    			$("#i1").attr("src","${pageContext.request.contextPath}"+data.obj)
    		}
    	});
    };

</script>

</html>