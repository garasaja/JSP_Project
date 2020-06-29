<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cos.blog.model.Product" %>
<%@ include file="../include/nav.jsp" %> 

<br/><br/><br/><br/><br/><br/>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">		
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="justify-content-center" id="Navbar">
		<ul class="navbar-nav">
			<li class="nav-item" ><a class="nav-link" href="/blog/product?cmd=register">상품등록</a></li>
			<li class="nav-item"><a class="nav-link" href="/blog/product?cmd=update">상품관리</a></li>
		</ul>

</div>
</nav>

<div class="container">
<form action="/blog/product?cmd=registerProc" method="POST" class="was-validated" onsubmit="return validate()" enctype="multipart/form-data">
	  <table class= "table table-striped" style="text-align: center; border:1px solid #dddddd">
	  	<thead>
	  		<tr>
	  			<th colspan="2"><div class="container">
    			<div class="d-flex justify-content-center">
	    	
    			<div class="form-group">
	    			<img id="img__wrap" onerror="this.src='blog/image/test.jpg" src="${product.pprofile}" width="200px" height="200px" />
    			</div>
    			<div class="form-group bg-light">
	    			<input type="file" name="pprofile" id="img__preview"/>
    			</div>
    			<input type="hidden" name="id" value="${sessionScope.principal.id}"/></th>
	  		<tr>
	  	</thead>
	  	<tbody>
	  		<tr>
	  		<div class="form-group">
	  			<td style="width:110px;"><h5>제목</h5></td>
	  			<td><input class="form-control" type="text" id="ptitle" name="ptitle" maxlength="40" placeholder="제목을 입력해 주세요"></td>
	  		</div>
	  		</tr>
	  		<tr>
	  			<div class="form-group">
	  				<td style="width:110px;"><h5>카테고리</h5></td>
	  					<td>
	  						<select name="pcategory">
    							<option value="남성의류">남성의류</option>
    							<option value="여성의류">여성의류</option>
    							<option value="디지털/가전">디지털/가전</option>
    							<option value="도서/티켓/취미/애완">도서/티켓/취미/애완</option>
    							<option value="생활/문구/가구/식품">생활/문구/가구/식품</option>
    							<option value="유아동/출산">유아동/출산</option>
    							<option value="스포츠/레저">스포츠/레저</option>
    							<option value="차량/오토바이">차량/오토바이</option>
    							<option value="기타">기타</option>  			
    						</select>
    					</td>
	  			</div>
	  		</tr>
	  		<tr>
	  			<div class="form-group">
		  			<td style="width:110px;"><h5>거래지역</h5></td>
	  				<td>
	  					<select name="pplace">
    						<option value="부산">부산</option>
    						<option value="울산">울산</option>
    						<option value="서울">서울</option>
    						<option value="대구">대구</option>
    						<option value="광주">광주</option>
			    		</select>
		    		</td>
	  			</div>
	  		</tr>
	  		<tr>
	  		<div class="form-group">
	  			<td style="width:110px;"><h5>가격</h5></td>
	  			<td><input class="form-control" type="text" id="pprice" name="pprice" placeholder="가격을 입력해주세요"></td>
	  		</div>
	  		</tr>
	  		<tr>
	  		<div class="form-group">
	  			<td style="width:110px;"><h5>설명</h5></td>
	  			<td><textarea name="pcontent" rows="10" cols="130" placeholder="상품 설명을 입력해주세요."></textarea></td>
	  		</div>
	  		</tr>
	  	</tbody>
	  	<tfoot>
	  		<tr>
	  		<td style="width:160px;"><button type="submit" class="btn btn-primary">상품등록</button></td>
	  		</tr>
	  	</tfoot>
	  	
	  	</table>
	  	</form>
	 </div> 	

<script src="/blog/js/imgPreview.js"></script>
<%@ include file="../include/footer.jsp" %>