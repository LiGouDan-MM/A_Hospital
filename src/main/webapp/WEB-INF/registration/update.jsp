<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
      String path = request.getContextPath()+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>">
    <title>挂号-- -2015</title>
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script type="text/javascript" src="Js/ckeditor/ckeditor.js"></script>
 
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
		$('#backid').click(function(){
				window.location.href="Registration/Query";
		 });
    });
    </script>
</head>
<body>
<form action="Registration/Update?id=${id }" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td><input type="text" name="name" value="${rAccept.name }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件类型</td>
        <td>
	        <select name="certificate_type">
	               <option value="1" ${rAccept.certificate_type==1?'selected':'' }>身份证</option>
	               <option value="2" ${rAccept.certificate_type==2?'selected':'' }>军人证</option>
	               <option value="3" ${rAccept.certificate_type==3?'selected':'' }>护照</option>
			</select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td><input type="text" name="ID_num" value="${rAccept.ID_num }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">挂号费</td>
        <td><input type="text" name="registration_fee" value="${rAccept.registration_fee }"/>元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td><input type="text" name="social_safe_num" value="${rAccept.social_safe_num }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td><input type="text" name="phone" value="${rAccept.phone }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
           <td>
             <!-- 1是自费0不是自费  -->
             <input type="radio" name="self_paying" value="0" ${rAccept.self_paying==0?'checked':'' }/>否&nbsp;&nbsp;&nbsp;
             <input type="radio" name="self_paying" value="1" ${rAccept.self_paying==1?'checked':'' } />是
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>
          <!-- 1是男的0是女的  -->
          <input type="radio" name="sex" value="1" ${rAccept.sex==1?'checked':'' }/>男&nbsp;&nbsp;&nbsp;
          <input type="radio" name="sex" value="0" ${rAccept.sex==0?'checked':'' }/>女
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td><input type="text" name="age" value="${rAccept.age }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">职业</td>
        <td><input type="text" name="career" value="${rAccept.career }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td>
           <input type="radio" name="early_appointment" ${rAccept.early_appointment=='初诊'?'checked':'' }/>初诊&nbsp;&nbsp;&nbsp;
           <input type="radio" name="early_appointment" ${rAccept.early_appointment=='复诊'?'checked':'' }/>复诊
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td>
          <select name="section_id">
             <c:forEach items="${section }" var="section">
                <option value="${section.id }" ${section.secco_name==rAccept.secco_name?'selected':'' }>${section.secco_name }</option>
             </c:forEach>
          </select>
       </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td>
          <select name="doctor_id">
             <c:forEach items="${doctor }" var="doctor">
                 <option value="${doctor.id }" ${doctor.name==rAccept.docName?'selected':'' }>${doctor.name }</option>
             </c:forEach>
          </select></td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>
            <textarea name="noted">${rAccept.noted }</textarea>
       </td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
                                                                                            
</body>
</html>  