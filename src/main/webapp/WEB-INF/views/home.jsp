<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Spring Legacy Report</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script>
		function chkExt(fr){
			var filePath = fr.dbfile.value;
			if(filePath.substr(filePath.length - 7) == ".dbfile"){ return true;}
			else {
				alert('.dbfile 확장자 형식으로만 업로드할 수 있습니다.'); 
				return false;
			}
		}
	</script>
</head>
<body>
<div class="container">
  <h2>1차 과제</h2>
  <div class="panel panel-default">
    <div class="panel-heading">파일 업로드 페이지</div>
    <div class="panel-body">
    <form action="/file-upload" id="fileForm" name="fileForm" 
    method="post" enctype=multipart/form-data onsubmit="return chkExt(this);">
		<input type="file" id="dbfile" name="dbfile" accept=".dbfile"/>
		<input type="submit" value="파일업로드" />
	</form>
    <div class="panel-footer">recsee</div>
  </div>
</div>
	
</body>
</html>



