<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<br/><br/><br/><br/><br/><br/><br/>
	
<style>
img {
  	object-fit: cover;
	width: 130px;
	height: 130px;
}
 table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>

<div class="container">

	<h2>구매내역 보기</h2>
	
	<table>     
      <thead>
        <tr>          
          <th>이미지</th>
          <th>제목</th>
          <th>가격</th>
          <th>택배장소</th>
          <th>요청사항</th>
          <th>결제방법</th>
 
        </tr>
      </thead>
      <tbody id="body_id">       
        <c:forEach var="buydto" items="${buylist}">
		  <tr>
    	  <td width="60px"><img src="${buydto.pprofile}" alt=""></td>
          <td>${buydto.ptitle}</td>
          <td>${buydto.buy.buyprice}</td>
          <td>${buydto.buy.buyaddress}</td>
          <td>${buydto.buy.buyrequest}</td>
          <td>${buydto.buy.buypayment}</td>         
          </tr>      
   	    </c:forEach>
      </tbody>
     
    </table>
	</div>

	
<script src="/blog/js/productdetail.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script src="js/single_custom.js"></script>
<%@ include file="../include/footer.jsp"%>


