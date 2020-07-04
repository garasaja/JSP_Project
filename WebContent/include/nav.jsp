<%@page import="com.cos.blog.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>중고사랑 나라사랑</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Colo Shop Template">

<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/blog/css/styles.css" rel="stylesheet">
</head>
<body>

	

<div class="super_container">

	<!-- Header -->

	<header class="header trans_300">

		<!-- Top Navigation -->

		<div class="top_nav">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="top_nav_left">중고나라 사이트입니다.</div>
					</div>
					<div class="col-md-6 text-right">
						<div class="top_nav_right">
							<ul class="top_nav_menu">

								<!-- Currency / Language / My Account -->

								<li class="currency">
									<a href="#">
										상품
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="currency_selection">
										<li><a href="/blog/product?cmd=shop">상품리스트</a></li>
										<li><a href="/blog/product?cmd=register">상품글쓰기</a></li>
									</ul>
								</li>
								<li class="language">
									<a href="#">
										게시판
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="language_selection">
										<li><a href="/blog/board?cmd=home&page=0">게시판리스트</a></li>
										<li><a href="/blog/board?cmd=write">게시판글쓰기</a></li>
									</ul>
								</li>
								<li class="account">
									<a href="#">
										회원리스트
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="account_selection">
										<c:choose>
										<c:when test="${empty sessionScope.principal}">
										<li><a href="user?cmd=login">로그인</a></li>
										<li><a href="user?cmd=join">회원가입</a></li>
										</c:when>
										<c:otherwise>
										<li><a href="user?cmd=logout">로그아웃</a></li>
										<li><a href="user?cmd=update">회원정보변경</a></li>
										<li><a href="user?cmd=profileUpload">프로필</a></li>
										<li><a href="product?cmd=buyselect">주문내역</a></li>
										<li><a href="product?cmd=basketselect">장바구니</a></li>
										</c:otherwise>
									</c:choose>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Main Navigation -->

		<div class="main_nav_container">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-right">
						<div class="logo_container">
							<a href="index.jsp">중고<span>나라</span></a>
						</div>
						<nav class="navbar">
							<ul class="navbar_menu">
								<form class="form-inline d-flex justify-center" action="/blog/product?cmd=search">
								<input type="hidden" name="cmd" value="search" />
  								  <input class="form-control mr-sm-2" type="text" name="keyword" placeholder="상품(카테고리) 또는 내용을 검색해주세요" style="width: 500px" height="200px">
  								  <button class="btn btn-success" type="submit">Search</button>
 								 </form>
						
							</ul>
							<div class="hamburger_container">
								<i class="fa fa-bars" aria-hidden="true"></i>
							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>

	</header>

	<div class="fs_menu_overlay"></div>

	<!-- Hamburger Menu -->

	<div class="hamburger_menu">
		<div class="hamburger_close"><i class="fa fa-times" aria-hidden="true"></i></div>
		<div class="hamburger_menu_content text-right">
			<ul class="menu_top_nav">
				<li class="menu_item has-children">
					<a href="#">
						상품
						<i class="fa fa-angle-down"></i>
					</a>
					<ul class="menu_selection">
						<li><a href="/blog/product?cmd=shop">상품리스트</a></li>
						<li><a href="/blog/product?cmd=register">상품글쓰기</a></li>
					</ul>
				</li>
				<li class="menu_item has-children">
					<a href="#">
						게시판
						<i class="fa fa-angle-down"></i>
					</a>
					<ul class="menu_selection">
						<li><a href="/blog/board?cmd=home&page=0">게시판리스트</a></li>
						<li><a href="/blog/board?cmd=write">게시판글쓰기</a></li>
					</ul>
				</li>
				<li class="menu_item has-children">
					<a href="#">
						회원리스트
						<i class="fa fa-angle-down"></i>
					</a>
					<ul class="menu_selection">
						<c:choose>
										<c:when test="${empty sessionScope.principal}">
										<li><a href="user?cmd=login">로그인</a></li>
										<li><a href="user?cmd=join">회원가입</a></li>
										</c:when>
										<c:otherwise>
										<li><a href="user?cmd=logout">로그아웃</a></li>
										<li><a href="user?cmd=update">회원정보변경</a></li>
										<li><a href="user?cmd=profileUpload">프로필</a></li>
										<li><a href="product?cmd=buyselect">주문내역</a></li>
										<li><a href="product?cmd=basketselect">장바구니</a></li>
										</c:otherwise>
									</c:choose>
					</ul>
				</li>
				
			</ul>
		</div>
	</div>
	<br>