<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cos.blog.model.Product"%>
<%@ include file="../include/nav.jsp"%>
<br/><br/><br/><br/><br/><br/><br/><br/>
<div class="super_container">

	<div class="fs_menu_overlay"></div>

	

	<div class="container single_product_container">
		<div class="row">
			<div class="col">

				<!-- Breadcrumbs -->

				<div class="breadcrumbs d-flex flex-row align-items-center">
					<ul>
						<li><a href="index.html">수정</a></li>
						<li><a href="index.html">삭제</a></li>
						
						
					</ul>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-lg-7">
				<div class="single_product_pics">
					<div class="row">
					<c:forEach var="product" items="${productlist}">
					
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
					</c:forEach>
					<br/>
					
					<div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
						<button type="button" class="btn btn-primary">찜</button>
						<button type="button" class="btn btn-secondary">연락하기</button>
						<button type="button" class="btn btn-success">바로구매</button>
					</div>
				</div>
			</div>
		</div>

	</div>

	

					

				</div>
		
	
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script src="js/single_custom.js"></script>
<%@ include file="../include/footer.jsp"%>
