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
      <th>username</th>
      <th>password</th>
      <th>email</th>
      <th>address</th>
      <th>userprofile</th>
      <th>createDate</th>    
     
    </tr>
  </thead>
  <tbody id="user_${user.id}">
  <c:forEach var="users" items="${userlist}">
    <tr>
      <td>${users.id}</td>
      <td>${users.username}</td>
      <td>${users.password}</td>
      <td>${users.email}</td>
      <td>${users.address}</td>
      <td>${users.userProfile}</td>
 	  <td>${users.createDate}</td>
 	  <td><button class="btn btn-danger"  onclick="deleteById(${users.id})">삭제</button></td>
    </tr>
    </c:forEach>
    
  </tbody> 
</table>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
function deleteById(userId){
	$.ajax({
		type: "get",
		url: "/blog/admin?cmd=userdelete&userId="+userId,
// 		data: ",
// 		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text"
	}).done(function(result){
		if(result == "1"){
			alert("댓글 삭제 성공");
// 			var userItem = $("#user_"+userId);
// 			userItem.remove();
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