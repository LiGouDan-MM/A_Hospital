<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <!-- 引入 ECharts 文件 -->
    <script src="${pageContext.request.contextPath }/Js/echarts.min.js"></script>
</head>
<body>
      <div id="main" style="width: 600px;height:400px;"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery-1.11.0.js"></script>
<script type="text/javascript">
     // 页面加载完后干的事情
	 $(document).ready(function(){
		 $.ajax({
			url:"${pageContext.request.contextPath }/Check/showEchartsUI2",
		    success:function(data){
		    	var myChart = echarts.init(document.getElementById('main'));
		    	option = {
		    	    title: {
		    		    text: '折线图堆叠'
		    		    },
		    		    tooltip: {
		    		        trigger: 'axis'
		    		    },
		    		    legend: {
		    		        data:['骨科','妇科','急诊科','外科']
		    		    },
		    		    grid: {
		    		        left: '3%',
		    		        right: '4%',
		    		        bottom: '3%',
		    		        containLabel: true
		    		    },
		    		    toolbox: {
		    		        feature: {
		    		            saveAsImage: {}
		    		        }
		    		    },
		    		    xAxis: {
		    		        type: 'category',
		    		        boundaryGap: false,
		    		        data: ['周一','周二','周三','周四','周五','周六','周日']
		    		    },
		    		    yAxis: {
		    		        type: 'value'
		    		    },
		    		    series: [
		    		        {
		    		            name:'骨科',
		    		            type:'line',
		    		            //stack: '总量',
		    		            data:data[0]
		    		        },
		    		        {
		    		            name:'妇科',
		    		            type:'line',
		    		            //stack: '总量',
		    		            data:data[1]
		    		        },
		    		        {
		    		            name:'急诊科',
		    		            type:'line',
		    		            //stack: '总量',
		    		            data:data[2]
		    		        },
		    		        {
		    		            name:'外科',
		    		            type:'line',
		    		            //stack: '总量',
		    		            data:data[3]
		    		        },
		    		        
		    		    ]
		    	 };

		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
		    }
		 });
		 
	 });

</script>
</html>