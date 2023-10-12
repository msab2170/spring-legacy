<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Spring Legacy Report</title>
 	<meta charset="utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" type="text/css" href="/resources/codebase/dhtmlx.css">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="/resources/codebase/dhtmlx.js"></script>
</head>
<body>
<div class="container">
  <h2>2차 과제</h2>
  <div class="panel panel-default">
    <div class="panel-heading">입력된 목록</div>
    <div class="panel-body">
  		
		<div id="gridbox" style="width:100%; height:400px;"></div>
			<script>
			mygrid = new dhtmlXGridObject('gridbox');
		    mygrid.setImagePath("/resources/codebase/imgs/");                 //the path to images required by grid 
		    mygrid.setHeader("ID,PWD, NAME, LEVEL, DESC, REQ_DATE");//the headers of columns  
		    mygrid.setInitWidths("100,100,50,50,250,250");          //the widths of columns  
		    mygrid.setColumnIds("id,pwd,name,level,desc,expressDate");
		    mygrid.setColAlign("center,center,center,center,left,center");       //the alignment of columns   
		    mygrid.setColTypes("ed,ed,ed,ed,ed,ed");                //the types of columns  
		    mygrid.setColSorting("str,str,str,str,str,str");          //the sorting types   
		    mygrid.init();      //finishes initialization and renders the grid on the page 
		    $.ajax({
				type : "POST",			// 데이터 전송방법
				url : "/show-users",	
				dataType: "json",
				success:function(data){
					parsingGridData(data);	
				}
		  	});
		    
		    function parsingGridData(data) {
				var rows = [];
				$.each(data, function(i, item) {
					var array = new Array();
					array.push(item.id);
					array.push(item.pwd);
					array.push(item.name);
					array.push(item.level);
					array.push(item.desc);
					array.push(item.expressDate);
					var row = {id:i+1, data:array};
					rows.push(row);
				});
				var gridData={rows:rows};
				mygrid.parse(gridData, "json");
			}
			</script> 
  		
    </div>
    <div class="panel-footer">dodo</div>
  </div>
</div>



</body>
</html>
