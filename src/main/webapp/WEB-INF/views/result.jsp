<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.recsee.report.dto.*"%>


<html>
<head>
	<title>Spring Legacy Report</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <style>
  .display-none {
  	display:none;
  }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script>  
  function showUsers() {
	  $.ajax({
			type : "POST",			// 데이터 전송방법
			url : "/showUsers",	
			dataType: "json",
			success:function(data){
				if (data.length > 0) {
					
					var tb = $("<table />");
					tb.addClass("table");
					var head = $("<tr />").append(
							$("<th />").text("ID"),
							$("<th />").text("PWD"),
							$("<th />").text("NAME"),
							$("<th />").text("LEVEL"),
							$("<th />").text("DESC"),
							$("<th />").text("REG_DATE")
						);	
					tb.append(head);
					for(var i in data) {
						var $id= data[i].id;
						var $pwd = data[i].pwd;
						var $name = data[i].name;
						var $level = data[i].level;
						var $desc = data[i].desc;
						var $reg_date = data[i].expressDate;
						
						var row = $("<tr />").append(
							$("<td />").text($id),
							$("<td />").text($pwd),
							$("<td />").text($name),
							$("<td />").text($level),
							$("<td />").text($desc),
							$("<td />").text($reg_date)
						);
						tb.append(row);	
					}
					$(".wrap").append(tb);
				} else {
					$(".wrap").append("조회에 실패했습니다.");
				}
			}
	});
  }
  </script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
  
</head>
<body>
 
<div class="container">
  <h2>1차 과제</h2>
  <div class="panel panel-default">
    <div class="panel-heading">파일 업로드 결과</div>
    <div class="panel-body">
    <!-- 파일 전체 레코드 수가 total 이고 읽기 성공 레코드 수가 count 라면 --> 
   	<c:if test="${result.failCount == 0}">
 		레코드 <c:out value="${result.successCount}" /> 건 입력 성공 <input type="button" id="showUsersBtn" name="showUsersBtn" value="조회" onclick="showUsers();">
 		<br/><br/>
 		<div class="wrap"></div>
 	</c:if>
	<c:if test="${result.getFailCount() != 0}">
		성공 <c:out value="${result.successCount}" /> 건, 실패 <c:out value="${result.failCount}" /> 건 <br/><br/>
		# 실패 정보 <br/>
		<c:forEach var="readFailLine" items="${result.failList}">
		- 실패한 라인 : ${readFailLine.lineNum} / 실패한 라인의 내용 : ${readFailLine.lineContent}<br/>
		</c:forEach>
	</c:if>
    </div>
    <div class="panel-footer">Recsee</div>
  </div>
</div>

</body>
</html>



