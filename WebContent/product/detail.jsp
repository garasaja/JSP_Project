<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cos.blog.model.Product"%>
<%@ include file="../include/nav.jsp"%>


<%--
	
	Users u = (Users)session.getAttribute("principal");
	if (u==null) {
		System.out.println("u == null");
		return;
	}
	Product p = (Product)request.getAttribute("product");
	if (p==null) {
		System.out.println("p == null");
		return;
	}
	System.out.println(u.getId());
	System.out.println(p.getPuserId());

--%>
<br/><br/><br/><br/><br/><br/><br/><br/>
<div class="super_container">

	<div class="fs_menu_overlay"></div>

	

	<div class="container single_product_container">
		<div class="row">
			<div class="col">

				<!-- Breadcrumbs -->

				<c:if test="${sessionScope.principal.id == product.puserId}">
					<a href="/blog/product?cmd=update&id=${product.pid}" class="btn btn-warning">수정</a>
					<button class="btn btn-danger" onclick="deleteById(${product.pid})">삭제</button>
				</c:if>

			</div>
		</div>

		<div class="row">
			<div class="col-lg-7">
				<div class="single_product_pics">
					<div class="row">
<%-- 					<c:forEach var="product" items="${product}"> --%>
					
						<img src="${product.pprofile}"/>
						
					</div>
				</div>
			</div>
			<div class="col-lg-5">
				<div class="product_details">
					<div class="product_details_title">
					
						<h2>${product.ptitle}</h2>
						<p>${product.pcontent}</p>
					</div>
					
					
					<div class="product_price">${product.pprice}</div>
<%-- 					</c:forEach> --%>
					<br/>
					
					<div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
						<button type="button" class="btn btn-primary"  onclick ="like();" >찜</button>
						<button type="button" class="btn btn-secondary" onclick = "location.href ='/blog/product?cmd=chat'">연락하기</button>
						<button type="button" class="btn btn-success" onclick = "location.href ='/blog/product?cmd=buy'">바로구매</button>
					</div>
				</div>
			</div>
		</div>

	</div>

	

					

				</div>
		<script>
			function like() {
				alert("찜목록에 추가되었습니다.");
			}
		</script>
	
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script src="js/single_custom.js"></script>
<%@ include file="../include/footer.jsp"%>
