<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>
<br/><br/><br/><br/><br/><br/><br/><br/>

<div class="container">
	<form action="/blog/product?cmd=buyProc" method="POST" class="was-validated" onsubmit="return validate()">
	  <table border="1" bordercolor="blue" width ="800" height="500" align = "center" >
    <tr bgcolor="blue" align ="center">
	<p><td colspan = "3" span style="color:white">결제하기</td></p>
    </tr>
    <tr>
    <td>상품정보</td>
    <td>
    	<img src="${product.pprofile}" name="pprofile1" width="100px" height="100px"/>
    	${product.ptitle}                                    ${product.pprice}원
    	<input type="hidden" name="userid" value="${sessionScope.principal.id}" />
		<input type="hidden" name="productid" value="${product.pid}" />
		<input type="hidden" name="ptitle" value="${product.ptitle}" />
		<input type="hidden" name="pprofile" value="${product.pprofile}" />
		<input type="hidden" name="buyprice" value="${product.pprice}" /></td></tr>
    <tr>
	<td style="width:80px;">배송지</td>
	<td><input type="text" class="form-control" id="address" placeholder="배송지를 검색해주세요" name="buyaddress"  width="600px" readonly></td>
	  			<td style="width:110px"><button class="btn btn-primary" type="button" class="form-control" onclick="goPopup()">주소검색</button></td>
		
    </tr>
    <tr>
	<td style="width:80px;">배송요청사항</td>
	<td style="width:700px;"><select name="buyrequest">
    							<option value="문앞">문앞</option>
    							<option value="직접 받고 부재시 문앞">직접 받고 부재시 문앞</option>
    							<option value="경비실">경비실</option>
    							<option value="우편함">우편함</option>  										
    						</select></td>
	
    </tr>
    <tr>
	<td style="width:80px;">결제수단</td>
	<td>
	  						<select name="buypayment">
    							<option value="간편계좌결제">간편계좌결제</option>
    							<option value="신용카드">신용카드</option>
    							<option value="무통장입금(가상계좌)">무통장입금(가상계좌)</option>    										
    						</select>
    					</td>
	
    </tr>
    <tr>
	<td style="width:80px;">결제금액</td>
	<td name="buyprice">${product.pprice}원</td>
    
    <tr>
    <td></td>
    <td style="width:80px;"><button type="submit" class="btn btn-primary">결제하기</button></td>
    <td></td>
    </tr>

</table>
	  	</form>
	  <script src="${path}/js/juso.js"></script>

	<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="js/custom.js"></script>  
	  <%@ include file="../include/footer.jsp"%>