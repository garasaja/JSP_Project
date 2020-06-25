<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/nav.jsp" %> 

<nav class="navbar navbar-expand-md bg-dark navbar-dark">		
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="justify-content-center collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item" ><a class="nav-link" href="/blog/user?cmd=login">상품등록</a></li>
			<li class="nav-item"><a class="nav-link" href="/blog/user?cmd=join">상품관리</a></li>
		</ul>

</div>
</nav>

<div class="container">
    	<div class="d-flex justify-content-center">
	    	<form action="/blog/user?cmd=profileUploadProc" method="POST" enctype="multipart/form-data">
    			<div class="form-group">
	    			<img id="img__wrap" onerror="this.src='/blog/image/userProfile1.jpg'" src="${sessionScope.principal.userProfile}" width="200px" height="200px" />
    			</div>
    			<div class="form-group bg-light">
	    			<input type="file" name="userProfile" id="img__preview"/>
    			</div>
    			<input type="hidden" name="id" value="${sessionScope.principal.id}"/>
    			<div class="form-group">
    				<button class="btn btn-primary w-100">사진등록</button>	
    			</div>
    		</form>
    	
    	</div>
    	<hr/>
    	<form action="product/ProductRegisterProcAction">
    	제목 <input type="text">
    	<hr/>
    	카테고리
    		<select name="category">
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
    	
    	<hr/>
    	거래지역
    	<select name="place">
    			<option value="부산">남성의류</option>
    			<option value="울산">여성의류</option>
    			<option value="서울">디지털/가전</option>
    			<option value="대구">도서/티켓/취미/애완</option>
    			<option value="광주">생활/문구/가구/식품</option>
    			  			
    		</select>
    	<hr/>
    	가격<input type="text">
    	<hr/>
    	설명
    	<textarea rows="10" cols="40" placeholder="상품 설명을 입력해주세요."></textarea>
    	<hr/>
    	<button type="submit"></button>
    	</form>
    	
    </div>
    
<%@ include file="../include/footer.jsp" %>