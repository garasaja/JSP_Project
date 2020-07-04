<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	body{margin-top:20px;}

.toggleDisplay {
  display: none;
}
.toggleDisplay.in {
  display: table-cell;
}
    </style>
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


<table class="table table-bordered">
	<thead>
    <tr>
      <th><button onclick= "location.href='/blog/admin?cmd=user'">userlist</button></th>
      <th><button onclick= "location.href='/blog/admin?cmd=board'">boardlist</button></th>
      <th><button onclick= "location.href='/blog/admin?cmd=reply'">replylist</button></th>
      <th><button onclick= "location.href='/blog/admin?cmd=product'">productlist</button></th>       
    </tr>
  </thead>
</table>


<table class="table table-bordered">
  <thead>
    <tr>

      <th>id</th>
      <th>userid</th>
      <th>title</th>
      <th>content</th>
      <th>createdate</th>
   
     
    </tr>
  </thead>
  <tbody id="board-${board.id}">

  <c:forEach var="board" items="${boardlist}">
    <tr>
      <td>${board.id}</td>
      <td>${board.userId}</td>
      <td>${board.title}</td>
      <td>${board.content}</td>
      <td>${board.createDate}</td>
 	  <td><button class="btn btn-danger" onclick="deleteById(${board.id})">삭제</button></td>
    </tr>
    </c:forEach>
  
  </tbody> 
</table>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
function deleteById(boardId){
	$.ajax({
		type: "get",
		url: "/blog/admin?cmd=boarddelete&boardId="+boardId,
		//data: "boardId="+boardId,
		//contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text"
	}).done(function(result){
		if(result == "1"){
			alert("댓글 삭제 성공");
// 			var boardItem = $("#board-"+boardId);
// 			boardItem.remove();
			location.reload();
		}else{
			alert("댓글 삭제 실패");
		}
	}).fail(function(error){
		alert("댓글 삭제 실패");
	});
}
</script>
</body>
</html>