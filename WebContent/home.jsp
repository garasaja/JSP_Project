<%@page import="java.io.PrintWriter"%>
<%@page import="second.model.Member"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="include/nav.jsp"%>

<div class="container">

	<div class="m-1">
		<form class="form-inline d-flex justify-content-end" action="/second/product">
			<input type="hidden" name="cmd" value="search" />
			<input type="hidden" name="page" value="0" />
			
			<input type="text" name="keyword" class="form-control mr-sm-2" placeholder="Search">			
			<button class="btn btn-primary m-1">검색</button>
		
		</form>
	</div>

	
			<table width="1000">
				<tr height="100">
					<td align="center" colspan="4">
						<font size="6" color="black">상품보기</font>
					</td>
				</tr>
				<tr>
					<td align="center">
						<img src="./image/test.jpg" style="max-width: 100%; height: auto;">1<br/>사진1<br/>10000원
					</td>
					<td align="center">
						<img src="./image/test.jpg" style="max-width: 100%; height: auto;">2<br/>사진2<br/>10000원
					</td>
					<td align="center">
						<img src="./image/test.jpg" style="max-width: 100%; height: auto;">3<br/>사진3<br/>10000원
					</td>
					<td align="center">
						<img src="./image/test.jpg" style="max-width: 100%; height: auto;">4<br/>사진4<br/>10000원
					</td>
					
				</tr>
			</table>
	


	<br/>
	<br/>

	<%@ include file="include/paging.jsp"%>

</div>

<%@ include file="include/footer.jsp"%>
