<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cos.blog.model.Product" %>
<%@ include file="include/nav.jsp"%>

<br/><br/><br/><br/><br/><br/><br/>
	
	<!-- Tabs -->

	<div class="tabs_section_container">

		
			</div>
	

	<!-- New Arrivals -->

	<div class="new_arrivals">
		<div class="container">
			
			
			<div class="row">
				<div class="col">
					<div class="product-grid" data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>

						<!-- Product 1 -->
						<c:forEach var="product" items="${productlist}">
						<div class="product-item men">
							<div class="product discount product_filter">
								<div class="product_image">
									<a href="/blog/product?cmd=detail&pid=${product.pid}"><img src="${product.pprofile}" alt="사진이 없음"></a>
								</div>
<!-- 								<div class="favorite favorite_left"></div> -->
								<div class="product_info">
									<h6 class="product_name"><a href="/blog/product?cmd=detail&pid=${product.pid}">${product.ptitle}</a></h6>
									<div class="product_price">${product.pprice}원</div>
								</div>
							</div>
<%-- 							<div class="red_button add_to_cart_button"><a href="/blog/product?cmd=detail&pid=${product.pid}">add to cart</a></div> --%>
						</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>

	

	

	
	
	<%@ include file="include/footer.jsp"%>

</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="js/custom.js"></script>
</body>

</html>
