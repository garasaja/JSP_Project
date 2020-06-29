<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cos.blog.model.Product" %>
<%@ include file="include/nav.jsp"%>

<br/><br/><br/><br/><br/><br/><br/>
	
	<!-- Tabs -->

	<div class="tabs_section_container">

		<div class="container">
			<div class="row">
				<div class="col">
					<div class="tabs_container">
						<ul class="tabs d-flex flex-sm-row flex-column align-items-left align-items-md-center justify-content-center">
							<li class="tab active" data-active-tab="tab_1"><span>상품리스트    </span></li>
							<li class="tab" data-active-tab="tab_2"><span>상품 쓰기    </span></li>
							<li class="tab" data-active-tab="tab_3"><span>상품 업데이트    </span></li>
						</ul>
					</div>
				</div>
			</div>
			</div>
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
									<img src="${product.pprofile}" alt="">
								</div>
								<div class="favorite favorite_left"></div>
								<div class="product_info">
									<h6 class="product_name"><a href="/blog/product?cmd=detail&pid=${product.pid}">${product.ptitle}</a></h6>
									<div class="product_price">${product.pprice}</div>
								</div>
							</div>
							<div class="red_button add_to_cart_button"><a href="/blog/product?cmd=detail&pid=${product.pid}">add to cart</a></div>
						</div>
						</c:forEach>
<!--  						Product 2 --> 

<!-- 						<div class="product-item women"> -->
<!-- 							<div class="product product_filter"> -->
<!-- 								<div class="product_image"> -->
<!-- 									<img src="image/test.jpg" alt=""> -->
<!-- 								</div> -->
<!-- 								<div class="favorite"></div> -->
<!-- 								<div class="product_bubble product_bubble_left product_bubble_green d-flex flex-column align-items-center"><span>new</span></div> -->
<!-- 								<div class="product_info"> -->
<!-- 									<h6 class="product_name"><a href="single.html">Samsung CF591 Series Curved 27-Inch FHD Monitor</a></h6> -->
<!-- 									<div class="product_price">$610.00</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div> -->
<!-- 						</div> -->

<!-- 						Product 3 -->

<!-- 						<div class="product-item women"> -->
<!-- 							<div class="product product_filter"> -->
<!-- 								<div class="product_image"> -->
<!-- 									<img src="images/product_3.png" alt=""> -->
<!-- 								</div> -->
<!-- 								<div class="favorite"></div> -->
<!-- 								<div class="product_info"> -->
<!-- 									<h6 class="product_name"><a href="single.html">Blue Yeti USB Microphone Blackout Edition</a></h6> -->
<!-- 									<div class="product_price">$120.00</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div> -->
<!-- 						</div> -->

<!-- 						Product 4 -->

<!-- 						<div class="product-item accessories"> -->
<!-- 							<div class="product product_filter"> -->
<!-- 								<div class="product_image"> -->
<!-- 									<img src="images/product_4.png" alt=""> -->
<!-- 								</div> -->
<!-- 								<div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>sale</span></div> -->
<!-- 								<div class="favorite favorite_left"></div> -->
<!-- 								<div class="product_info"> -->
<!-- 									<h6 class="product_name"><a href="single.html">DYMO LabelWriter 450 Turbo Thermal Label Printer</a></h6> -->
<!-- 									<div class="product_price">$410.00</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div> -->
<!-- 						</div> -->

<!-- 						Product 5 -->

<!-- 						<div class="product-item women men"> -->
<!-- 							<div class="product product_filter"> -->
<!-- 								<div class="product_image"> -->
<!-- 									<img src="images/product_5.png" alt=""> -->
<!-- 								</div> -->
<!-- 								<div class="favorite"></div> -->
<!-- 								<div class="product_info"> -->
<!-- 									<h6 class="product_name"><a href="single.html">Pryma Headphones, Rose Gold & Grey</a></h6> -->
<!-- 									<div class="product_price">$180.00</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div> -->
<!-- 						</div> -->

<!-- 						Product 6 -->

<!-- 						<div class="product-item accessories"> -->
<!-- 							<div class="product discount product_filter"> -->
<!-- 								<div class="product_image"> -->
<!-- 									<img src="images/product_6.png" alt=""> -->
<!-- 								</div> -->
<!-- 								<div class="favorite favorite_left"></div> -->
<!-- 								<div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div> -->
<!-- 								<div class="product_info"> -->
<!-- 									<h6 class="product_name"><a href="#single.html">Fujifilm X100T 16 MP Digital Camera (Silver)</a></h6> -->
<!-- 									<div class="product_price">$520.00<span>$590.00</span></div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div> -->
<!-- 						</div> -->

<!-- 						Product 7 -->

<!-- 						<div class="product-item women"> -->
<!-- 							<div class="product product_filter"> -->
<!-- 								<div class="product_image"> -->
<!-- 									<img src="images/product_7.png" alt=""> -->
<!-- 								</div> -->
<!-- 								<div class="favorite"></div> -->
<!-- 								<div class="product_info"> -->
<!-- 									<h6 class="product_name"><a href="single.html">Samsung CF591 Series Curved 27-Inch FHD Monitor</a></h6> -->
<!-- 									<div class="product_price">$610.00</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div> -->
<!-- 						</div> -->

<!-- 						Product 8 -->

<!-- 						<div class="product-item accessories"> -->
<!-- 							<div class="product product_filter"> -->
<!-- 								<div class="product_image"> -->
<!-- 									<img src="images/product_8.png" alt=""> -->
<!-- 								</div> -->
<!-- 								<div class="favorite"></div> -->
<!-- 								<div class="product_info"> -->
<!-- 									<h6 class="product_name"><a href="single.html">Blue Yeti USB Microphone Blackout Edition</a></h6> -->
<!-- 									<div class="product_price">$120.00</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div> -->
<!-- 						</div> -->

<!-- 						Product 9 -->

<!-- 						<div class="product-item men"> -->
<!-- 							<div class="product product_filter"> -->
<!-- 								<div class="product_image"> -->
<!-- 									<img src="images/product_9.png" alt=""> -->
<!-- 								</div> -->
<!-- 								<div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>sale</span></div> -->
<!-- 								<div class="favorite favorite_left"></div> -->
<!-- 								<div class="product_info"> -->
<!-- 									<h6 class="product_name"><a href="single.html">DYMO LabelWriter 450 Turbo Thermal Label Printer</a></h6> -->
<!-- 									<div class="product_price">$410.00</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div> -->
<!-- 						</div> -->

<!-- 						Product 10 -->

<!-- 						<div class="product-item men"> -->
<!-- 							<div class="product product_filter"> -->
<!-- 								<div class="product_image"> -->
<!-- 									<img src="images/product_10.png" alt=""> -->
<!-- 								</div> -->
<!-- 								<div class="favorite"></div> -->
<!-- 								<div class="product_info"> -->
<!-- 									<h6 class="product_name"><a href="single.html">Pryma Headphones, Rose Gold & Grey</a></h6> -->
<!-- 									<div class="product_price">$180.00</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div> -->
<!-- 						</div> -->
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
