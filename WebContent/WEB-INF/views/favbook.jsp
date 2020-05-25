<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="ebook.entity.truyen"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Your favorite book</title>
<base href="${pageContext.servletContext.contextPath}/">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Favicons -->
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="apple-touch-icon" href="images/icon.png">

<!-- Google font (font-family: 'Roboto', sans-serif; Poppins ; Satisfy) -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,600i,700,700i,800"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900"
	rel="stylesheet">

<!-- Stylesheets -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/plugins.css">
<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
<link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
<link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome.css">
<!-- Cusom css -->
<link rel="stylesheet" href="css/custom.css">

<!-- Modernizer js -->
<script src="js/vendor/modernizr-3.5.0.min.js"></script>
</head>
<style>
.scrollable-menu {
	height: auto;
	max-height: 300px;
	overflow-x: hidden;
	font-size: 14px;
	width: 350px;
}
</style>
<body>
	<!--[if lte IE 9]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
	<![endif]-->
	<c:set var="btnPrevious" value="1" />
	<c:forEach var="item" items="${chapter}" varStatus="loop">
		<c:if test="${item.idChapter==content.idChapter}">
			<c:set var="btnPrevious" value="${loop.index}" />
		</c:if>
	</c:forEach>

	<!-- Main wrapper -->
	<div class="wrapper" id="wrapper">

		<!-- Header -->
		<!-- Header -->
		<header id="wn__header"
			class="header__area header__absolute sticky__header is-sticky">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6 col-sm-6 col-6 col-lg-2">
						<div class="logo">
							<a href="home.htm"> <img src="images/logo/Books-banner.png"
								alt="logo images">
							</a>
						</div>
					</div>
					<div class="col-lg-8 d-none d-lg-block">
						<nav class="mainmenu__nav">
							<ul class="meninmenu d-flex justify-content-start">
								<li class="drop with--one--item"><a href="home.htm">Trang
										chủ</a></li>

								<li class="drop"><a><p style="color: white !important">Thể
											loại</p></a>

									<div class="megamenu mega04">
										<c:set var="count" value="1" />
										<%
											for (int i = 0; i < 6; i += 1) {
										%>
										<ul class="item item03">
											<c:forEach var="u" items="${categories}" begin="${count}"
												end="${count+4}">
												<li><a href="theloai/${u.idTheLoai}/1.htm">${u.tenTheLoai }
												</a></li>
											</c:forEach>
										</ul>
										<c:set var="count" value="${count + 5}" scope="page" />
										<%
											}
										%>

									</div>
							</ul>
						</nav>
					</div>
					<div class="col-md-6 col-sm-6 col-6 col-lg-2">


					
						<ul
							class="header__sidebar__right d-flex justify-content-end align-items-center">
							<li class="shop_search"><a class="search__active" href="#"></a></li>
							<li class="wishlist"><a href="#"></a></li>
							<!-- Start Shopping Cart -->

							<!-- End Shopping Cart -->
							<li class="setting__bar__icon"><a class="setting__active"
								href="#"></a>
								<div class="searchbar__content setting__block">
									<div class="content-inner">
										<div class="switcher-currency">
											<c:choose>
												<c:when test="${sessionScope.nickname != NULL}">
													<strong class="label switcher-label"
														style="text-align: center !important"> <span>${sessionScope.username}</span>
													</strong>
													<div class="switcher-options">

														<a href="account/logout.htm" class="dropdown-item"><i
															class="fas fa-user mr-2"></i>Account</a> <a
															class="dropdown-item" href="account/logout.htm"><i
															class="fas fa-power-off mr-2"></i>Logout</a>
													</div>


												</c:when>
												<c:otherwise>
													<strong class="label switcher-label"><a
														href="account.htm"> <span>Login</span></a> </strong>
													<div class="switcher-options">
														<strong class="label switcher-label"><a
															href="account/register.htm"> <span>Create
																	account</span></a> </strong>
													</div>
												</c:otherwise>
											</c:choose>
										</div>


									</div>
								</div></li>

						</ul>
					</div>
				</div>
				<!-- Start Mobile Menu -->

				<!-- End Mobile Menu -->
				<div class="mobile-menu d-block d-lg-none"></div>
				<!-- Mobile Menu -->
			</div>
		</header>
		<!-- //Header -->
		<!-- Start Search Popup -->
		<div class="box-search-content search_active block-bg close__top">
			<form id="search_mini_form" class="minisearch" action="#">
				<div class="field__search">
					<input type="text" placeholder="Search entire store here...">
					<div class="action">
						<a href="#"><i class="zmdi zmdi-search"></i></a>
					</div>
				</div>
			</form>
			<div class="close__wrap">
				<span>close</span>
			</div>
		</div>
		<!-- //Header -->
		<!-- Start Search Popup -->
		<div class="box-search-content search_active block-bg close__top">
			<form id="search_mini_form" class="minisearch" action="#">
				<div class="field__search">
					<input type="text" placeholder="Search entire store here...">
					<div class="action">
						<a href="#"><i class="zmdi zmdi-search"></i></a>
					</div>
				</div>
			</form>
			<div class="close__wrap">
				<span>close</span>
			</div>
		</div>
		<!-- End Search Popup -->
		<!-- Start Bradcaump area -->

		<!-- End Bradcaump area -->
		<!-- Start About Area -->
		<div class="cart-main-area section-padding--lg bg--white">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12 ol-lg-12">
						<form action="#">
							<div class="table-content wnro__table table-responsive">
								<table>
									<thead>
										<tr class="title-top">
											<th class="product-thumbnail"></th>
											<th class="product-name">Tên truyện</th>
											<th class="product-price">Tác giả</th>
											<th class="product-subtotal">Thể loại</th>
											<th class="product-remove"></th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="u" items="${listFavBook}">
										<tr>
											<td class="product-thumbnail"><a href="#"><img
													src="${u.image}" alt="product img"></a></td>
											<td class="product-name"><a href="truyen/${u.idTruyen}.htm">${u.tenTruyen}</a></td>
											<td class="product-price"><span class="amount">${u.tacGia}</span></td>
											<td class="product-subtotal"><a href ="theloai/${u.idTheLoai.idTheLoai}/1.htm">${u.idTheLoai.tenTheLoai}</a></td>
											<td class="product-remove"><a href="favbook/delete/${u.idTruyen}.htm"><i class="zmdi zmdi-delete"></i></a></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</form>
						<div class="cartbox__btn">
							<ul
								class="cart__btn__list d-flex flex-wrap flex-md-nowrap flex-lg-nowrap justify-content-between">
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End About Area -->
		<!-- Start Team Area -->

		<!-- End Team Area -->
		<!-- Footer Area -->
		<footer id="wn__footer" class="footer__area bg__cat--8 brown--color">
			<div class="footer-static-top">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="footer__widget footer__menu">
								<div class="ft__logo">
									<a href="home.htm"> <img src="images/logo/3.png" alt="logo">
									</a>
									<p>There are many variations of passages of Lorem Ipsum
										available, but the majority have suffered duskam alteration
										variations of passages</p>
								</div>
								<div class="footer__content">
									<ul
									class="social__net social__net--2 d-flex justify-content-center">
									<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
									<li><a href="#"><i class="fab fa-google" ></i></a></li>
									<li><a href="#"><i class="fab fa-twitter"></i></a></li>
									<li><a href="#"><i class="fab fa-linkedin"></i></a></li>
									<li><a href="#"><i class="fab fa-youtube"></i></a></li>
								</ul>
								<ul class="mainmenu d-flex justify-content-center">
									<li><a href="index.html">Trending</a></li>
									<li><a href="index.html">Best Seller</a></li>
									<li><a href="index.html">All Product</a></li>
									<li><a href="index.html">Wishlist</a></li>
									<li><a href="index.html">Blog</a></li>
									<li><a href="index.html">Contact</a></li>
								</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</footer>
		<!-- //Footer Area -->

	</div>
	<!-- //Main wrapper -->



	<!-- JS Files -->
	<script src="js/vendor/jquery-3.2.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/active.js"></script>

</body>
</html>