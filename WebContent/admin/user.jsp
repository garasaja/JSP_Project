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

      <th>id</th>
      <th>username</th>
      <th>password</th>
      <th>email</th>
      <th>address</th>
      <th>userprofile</th>
      <th>createdate</th>    
     
    </tr>
  </thead>
  <tbody>
  <c:forEach var="users" items="${userlist}">
    <tr>
      <td>${users.id}</td>
      <td>${users.username }</td>
      <td>${users.password }</td>
      <td>${users.emial }</td>
      <td>${users.address }</td>
      <td>${users.userprofile }</td>
 	  <td>${users.createdate }</td>
 	  <td>delete</td>
    </tr>
    </c:forEach>
    
  </tbody> 
</table>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$("#click-me").click(function() {
    $(".table .toggleDisplay").toggleClass("in");
});
</script>
</body>
</html>