<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%
       String path = request.getContextPath()+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>">
    <title>门诊查询-- -2015</title>
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <script type="text/javascript">
	 $(function () {
		$('#newNav').click(function(){
				window.location.href="Registration/AddTrain";
		 });
    });
	
    	function checkall(){
			var alls=document.getElementsByName("check");
			var ch=document.getElementById("checkAll");
			if(ch.checked){
				for(var i=0;i<alls.length;i++){
					alls[i].checked=true;	
				}	
			}else{
				for(var i=0;i<alls.length;i++){
					alls[i].checked=false;	
				}	
			}
		}
    	
		function delAll(){
			var alls=document.getElementsByName("check");
			var ids=new Array();
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked){
					ids.push(alls[i].value);
				}		
			}
			if(ids.length>0){
				if(confirm("确认操作?")){
					alert("成功!");
				}
			}else{
				alert("请选中要操作的项");
			}
		}
    </script>
</head>
<body>

<form action="Registration/Query" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病历号：</td>
        <td><input type="text" name="medical_record" value=""/></td>
		
        <td width="10%" class="tableleft">主治医生：</td>
        <td><input type="text" name="docName" value=""/></td>
		
        <td width="10%" class="tableleft">科室：</td>
        <td><input type="text" name="secco_name" value=""/></td>
    </tr>
    <tr>
		
        <td width="10%" class="tableleft">挂号时间：</td>
		  <td colspan="5">
			<input type="date" name="time1" />&nbsp;至&nbsp;
			<input type="date" name="time2" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-primary" type="button">查询</button> 
            <button type="submit" class="btn btn-primary" type="button">清空</button> 
        </td>
    </tr>
</table>
</form>
<form action="Registration/Delete" method="post">
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkAll" onChange="checkall();"></th>
        <th>门诊编号</th>
        <th>主治医生</th>
        <th>挂号时间</th>
        <th>挂号科室</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${list }" var="list" varStatus="status">
	     <tr >
         	<td style="vertical-align:middle;">
         	<input type="checkbox" name="check" value="${list.id }"></td>
            <td style="vertical-align:middle;">${list.patientNum }</td>
            <td style="vertical-align:middle;">${list.doctor.name }</td>
            <td style="vertical-align:middle;"><fmt:formatDate value="${list.time }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
            <td style="vertical-align:middle;">${list.section.secco_name }</td>
            <td style="vertical-align:middle;">${list.status }</td>
            <td style="vertical-align:middle;">
			   <a href="Registration/Detail?name=${list.name }&certificate_type=${list.certificate_type}&ID_num=${list.ID_num}&registration_fee=${list.registration_fee}&social_safe_num=${list.social_safe_num}&phone=${list.phone}&self_paying=${list.self_paying}&sex=${list.sex}&age=${list.age}&career=${list.career}&early_appointment=${list.early_appointment}&secco_name=${list.section.secco_name}&docName=${list.doctor.name}&noted=${list.noted}">详情>>></a>&nbsp;&nbsp;&nbsp;
               <a href="Registration/Update?id=${list.id }&name=${list.name }&certificate_type=${list.certificate_type}&ID_num=${list.ID_num}&registration_fee=${list.registration_fee}&social_safe_num=${list.social_safe_num}&phone=${list.phone}&self_paying=${list.self_paying}&sex=${list.sex}&age=${list.age}&career=${list.career}&early_appointment=${list.early_appointment}&secco_name=${list.section.secco_name}&docName=${list.doctor.name}&noted=${list.noted}">更改</a>&nbsp;&nbsp;&nbsp;
               <a href="Registration/Back?id=${list.id }">退号</a></td>
        </tr>
	</c:forEach>     
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
          <c:choose>
             <c:when test="${page<=1 }">
                  <a href="javascript:void(0)">上一页</a>     
             </c:when>
             <c:otherwise>
                  <!--不能换行,不然会有空格  -->
                  <a href="Registration/Query?pageJsp=${page-1}&medical_record=${medical_record }&docName=${docName }&secco_name=${secco_name }&time1=${time1 }&time2=${time2}">上一页</a>
             </c:otherwise>
          </c:choose>
           <span class='current'></span>
           &nbsp;&nbsp;&nbsp;共<span class='current'>${total }</span>条记录<span class='current'> ${page } / ${pageNum } </span>页
           <c:choose>
             <c:when test="${page>=pageNum }">
                  <a href="javascript:void(0)">下一页</a>     
             </c:when>
             <c:otherwise>
                  <!--不能换行,不然会有空格  -->
                  <a href="Registration/Query?pageJsp=${page+1}&medical_record=${medical_record}&docName=${docName }&secco_name=${secco_name }&time1=${time1 }&time2=${time2}">下一页</a>
             </c:otherwise>
          </c:choose>
		 </div>
		 <div><button type="button" class="btn btn-success" id="newNav">门诊挂号</button>&nbsp;&nbsp;&nbsp;
		 <button type="submit" class="btn btn-success" id="delPro" onClick="delAll();">退号</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="delPro">导出Excel</button>
		 <button type="button" class="btn btn-success" id="delPro">打印</button>
		 </div>
		 </th></tr>
  </table>
  
</form>                                                                                   
</body>
</html>