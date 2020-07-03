<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cos.blog.model.Product" %>
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

	<h2>장바구니 보기</h2>
	
	<table>     
      <thead>
        <tr>          
          <th>이미지</th>
          <th>제목</th>
          <th>가격</th>
          <th>카테고리</th>
          <th>장소</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody id="body_id">       
        <c:forEach var="basketResponseDtos" items="${basketResponseDtos}">
		<tr id="delete-${basketResponseDtos.basket.id}">
    	  <td width="60px"><img src="${basketResponseDtos.pprofile}" alt="사진이 없습니다."/></td>
          <td>${basketResponseDtos.ptitle}</td>
          <td>${basketResponseDtos.pprice}</td>
          <td>${basketResponseDtos.pcategory}</td>
          <td>${basketResponseDtos.pplace}</td>
          <td width="60px"><input onclick="deletebybasketid(${basketResponseDtos.basket.id})" type="button" value="삭제"></td>    
          <td width="60px"><button type="button" class="btn btn-success" onclick = "location.href ='/blog/product?cmd=buy&pid=${basketResponseDtos.basket.productid}'">바로구매</button></td>
          </tr>      
   	    </c:forEach>
      </tbody>
     
    </table>
	
	
	
	
	
<!-- 	<div class="row"> -->
	
<!-- 	  <div class="col-sm-7"> -->
<%-- 	  	<c:forEach var="entry" items="${cart}"> --%>
<!-- 	  		<div class="row border border-left-0 border-right-0"> -->
<!-- 				<div class="col"> -->
<%-- 					<img src="${entry.key.image1}"/> --%>
<!-- 				</div> -->
<!-- 				<div class="col"> -->
<%-- 				 	${entry.key.name} --%>
<!-- 				</div> -->
<!-- 				<div class="col"> -->
<!-- 				 	<span style="cursor:pointer;" id="minus" onclick="minusQuantity()">➖ </span> -->
<%-- 							<input type="text" id="quantity" name="quantity" value="${entry.value}" size="1"> --%>
<!-- 							<span style="cursor:pointer;" id="plus" onclick="plusQuantity()">➕</span> -->
<!-- 				</div> -->
<!-- 				<div class="col"> -->
<%-- 					${entry.key.price}원 --%>
<!-- 				</div> -->
				
				
<!-- 			</div> -->
<%-- 	  	</c:forEach> --%>
	  	
<!-- 	  </div> -->
	  
	  
<!-- 	  <div class="col-sm-5"> -->
<!-- 	  	<div class="row">오른쪽 5번</div> -->
<!-- 	  </div> -->

<!-- 	</div> -->

<!-- </div> -->
	

	
	
	<%@ include file="../include/footer.jsp"%>

</div>
<script src="js/basket.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="js/custom.js"></script>
</body>

</html>
