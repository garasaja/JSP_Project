<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="/blog/product?cmd=buyProc" method="POST" class="was-validated" onsubmit="return validate()">
	  <table class= "table table-bordered table-hover" style="text-align: center; border:1px solid #dddddd">
	  	<thead>
	  		<tr>
	  			<th colspan="3"><h4>결제하기(택배거래)</h4></th>
	  		<tr>
	  	</thead>
	  	<tbody>
	  		<tr>
	  		<div class="form-group">
	  			<td style="width:110px;"><h5>배송지</h5></td>
	  			<td><input type="text" class="form-control" id="address" placeholder="배송지를 검색해주세요" name="address" required readonly></td>
	  			<td style="width:110px"><button class="btn btn-primary" type="button" class="form-control" onclick="goPopup()">주소검색</button></td>
	  		</div>
	  		</tr>
	  		<tr>
	  		<div class="form-group">
	  				<td style="width:110px;"><h5>배송 요청사항</h5></td>
	  					<td>
	  						<select name="please">
    							<option value="문앞">문앞</option>
    							<option value="직접 받고 부재시 문앞">직접 받고 부재시 문앞</option>
    							<option value="경비실">경비실</option>
    							<option value="우편함">우편함</option>
    							<option value="직접입력">직접입력
    							<input type="text" class="form-control" id="address" placeholder="요청사항 입력"/>
    							</option>    										
    						</select>
    					</td>
	  			</div>
	  		</tr>
	  		<tr>
	  		<div class="form-group">
	  				<td style="width:110px;"><h5>결제수단</h5></td>
	  					<td>
	  						<select name="howmoney">
    							<option value="간편계좌결제">간편계좌결제</option>
    							<option value="신용카드">신용카드</option>
    							<option value="무통장입금(가상계좌)">무통장입금(가상계좌)</option>    										
    						</select>
    					</td>
	  			</div>
	  		</tr>
	  		<tr>
	  		<div class="form-group">
	  			<td style="width:110px;"><h5>결제금액</h5></td>
	  			<td>19000원</td>
	  		</div>
	  		</tr>
	  		
	  	</tbody>
	  	<tfoot>
	  		<tr>
	  		<td></td>
	  		<td style="width:160px;"><button type="submit" class="btn btn-primary">19000원 결제하기</button></td>
	  		</tr>
	  	</tfoot>
	  	</table>
	  	</form>
	  
</body>
</html>