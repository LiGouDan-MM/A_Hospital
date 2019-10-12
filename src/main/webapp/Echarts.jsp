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
	  // ajax发出请求,获得数据,利用echarts作图
	  $.ajax({
		 url:"${pageContext.request.contextPath }/Check/showEchartsUI", 
		 type:"GET",
		 success:function(data){
			 // 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('main'));
		        // 指定图表的配置项和数据
		        var option = {
		            title: {
		                text: 'ECharts 入门示例'
		            },
		            tooltip: {},
		            legend: {
		                data:['销量']
		            },
		            xAxis: {
		                data: ["周一","周二","周三","周四","周五","周六","周日"]
		            },
		            yAxis: {},
		            series: [{
		                name: '销量',
		                type: 'bar',
		               /*  type: 'line', */
		                data: data
		            }]
		        };

		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
		 }
	  });
  });


</script>
</html>