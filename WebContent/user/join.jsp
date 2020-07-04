<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %> 
<br/><br/><br/><br/><br/><br/>
<div class="container">
	<form action="/blog/user?cmd=joinProc" method="POST" class="was-validated" onsubmit="return validate()">
	  <table class= "table table-bordered table-hover" style="text-align: center; border:1px solid #dddddd">
	  	<thead>
	  		<tr>
	  			<th colspan="3"><h4>회원 등록 양식</h4></th>
	  		<tr>
	  	</thead>
	  	<tbody>
	  		<tr>
	  		<div class="form-group">
	  			<td style="width:110px;"><h5>아이디</h5></td>
	  			<td><input class="form-control" type="text" id="username" name="username" maxlength="20" placeholder="아이디를 입력해주세요"></td>
	  			<td style="width: 110px;"><button class="btn btn-primary" onclick="usernameCheck()" type="button">중복체크</button></td>
	  		</div>
	  		</tr>
	  		<tr>
	  		<div class="form-group">
	  			<td style="width:110px;"><h5>비밀번호</h5></td>
	  			<td><input class="form-control" type="password" id="password" name="password" maxlength="20" placeholder="비밀번호를 입력해주세요"></td>
	  		</div>
	  		</tr>  		
	  		<tr>
	  		<div class="form-group">
	  			<td style="width:110px;"><h5>이메일</h5></td>
	  			<td><input class="form-control" type="email" id="email" name="email" maxlength="40" placeholder="이메일을 입력해주세요"></td>
	  		</div>
	  		</tr>
	  		<tr>
	  		<div class="form-group">
	  			<td style="width:110px;"><h5>주소</h5></td>
	  			<td><input type="text" class="form-control" id="address" placeholder="Enter Address" name="address" required readonly></td>
	  			<td style="width:110px"><button class="btn btn-primary" type="button" class="form-control" onclick="goPopup()">주소검색</button></td>
	  		</div>
	  		</tr>
	  	</tbody>
	  	<tfoot>
	  		<tr>
	  		<td style="width:160px;"><button type="submit" class="btn btn-primary">회원가입완료</button></td>
	  		</tr>
	  	</tfoot>
	  	</table>
	  	</form>
	  
</div>

<script src="${path}/js/juso.js"></script>
<script src="${path}/js/join.js"></script>
<%@ include file="../include/footer.jsp" %>

