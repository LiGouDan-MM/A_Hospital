<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
        String path =request.getContextPath()+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path %>">
    <title>xx市第二人民医院信息管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${user_name }</span>
	
	<a href="login.jsp" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">医院管理系统</div></li>

		</ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.6.js"></script>
<script type="text/javascript" src="assets/js/bui.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [
			{id:'1',menu:[
				
		{text:'快速通道',items:[
		
		{id:'2',text:'挂号信息管理',href:'Registration/Query'},
		{id:'3',text:'门诊医生管理',href:'Doctor/Query'},
		{id:'4',text:'药品管理',href:'Medicine/Query'},
		{id:'5',text:'住院办理',href:'hospital/index.html'},
		{id:'6',text:'收费项目登记',href:'PayItems/Query'},
		{id:'7',text:'在院发药',href:'Dispensing/Query'},
		{id:'8',text:'住院结算',href:'HospitalClear/Query'},
		{id:'9',text:'月营业额统计',href:''},
		{id:'10',text:'年营业额统计',href:''},
		
		{id:'11',text:'用户管理',href:'User/Query'},
		{id:'12',text:'角色管理',href:'Role/index.html'},
		{id:'13',text:'资源管理',href:'Resource/index.html'},
		{id:'14',text:'密码设置	',href:'Resource/index.html'}
		
		]}

			
			]}
		
		];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
                                                                                            
</body>
</html>   