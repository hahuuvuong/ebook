<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="ebook.entity.truyen"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>${truyen.tenTruyen}</title>
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

								<li class="drop"><a href="#"><p
											style="color: white !important">Thể loại</p></a>

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
							</li>

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
		<div class="page-about about_area bg--white section-padding--lg">
			<div class="container"
				style="background-color: rgb(238, 238, 238) !important; border-radius: 30px; padding: 10px;">

				<h3 class="text-center" style="margin: 30px 30px 30px 30px;">
					<a href="truyen/${truyen.idTruyen}.htm">${truyen.tenTruyen}</a>
				</h3>
				<div class="text-center" style="margin: 30px 30px 30px 30px;">${content.tenChapter}</div>
				<div class="text-center">
				
	<!--  -->			<c:set var="btnTemp" value="0" />
				
				<c:forEach var="u" items="${chapter}" begin = "0" end = "${btnPrevious}" varStatus="count">
				<c:if test="${btnTemp==btnPrevious - 1}">
					<a href="chapter/${truyen.idTruyen}/${u.idChapter}.htm"><button type="button" class="btn btn-default" style="margin-right: 5px !important"><i class="zmdi zmdi-arrow-left"></i></button></a>
					</c:if>
					<c:set var="btnTemp" value="${count.count}" />
					</c:forEach>
					
					
					<div class="btn-group text-center">
						<button type="button" class="btn btn-sm btn-info dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Chọn Tập <span class="caret"></span>
						</button>
						<ul class="dropdown-menu scrollable-menu">
							<c:forEach var="u" items="${chapter}">
								<c:choose>
									<c:when test="${u.idChapter==content.idChapter}">
        							<a href="chapter/${truyen.idTruyen}/${u.idChapter}.htm"><li class="list-group-item active">${u.tenChapter}</li></a>
									</c:when>
									<c:otherwise>
      								<a href="chapter/${truyen.idTruyen}/${u.idChapter}.htm"><li class="list-group-item">${u.tenChapter}</li></a>
									</c:otherwise>
								</c:choose>
								
							</c:forEach>
						</ul>
					</div>
					
					
				<c:set var="btnTemp" value="0" />
				
				<c:forEach var="u" items="${chapter}" begin = "0" end = "${btnPrevious+1}" varStatus="count">
				<c:if test="${btnTemp==btnPrevious + 1}">
					<a href="chapter/${truyen.idTruyen}/${u.idChapter}.htm"><button type="button" class="btn btn-default" style="margin-left: 5px !important"><i class="zmdi zmdi-arrow-right"></i></button></a>
					</c:if>
					<c:set var="btnTemp" value="${count.count}" />
					</c:forEach>
				
				
				</div>
				<hr style="border-top: 1px solid black; margin: 30px 30px 30px 30px;">

				<div style="color: black; font-size: 18px; padding:20px;">${content.noiDung}</div>
				<hr style="border-top: 1px solid black; margin: 30px 30px 30px 30px;">
				
				<div class="text-center"  style=" margin: 30px 30px 30px 30px;!important" >
				
	<!--  -->			<c:set var="btnTemp" value="0" />
				
				<c:forEach var="u" items="${chapter}" begin = "0" end = "${btnPrevious}" varStatus="count">
				<c:if test="${btnTemp==btnPrevious - 1}">
					<a href="chapter/${truyen.idTruyen}/${u.idChapter}.htm"><button type="button" class="btn btn-default" style="margin-right: 5px !important"><i class="zmdi zmdi-arrow-left"></i></button></a>
					</c:if>
					<c:set var="btnTemp" value="${count.count}" />
					</c:forEach>
					
					
					<div class="btn-group text-center">
						<button type="button" class="btn btn-sm btn-info dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Chọn Tập <span class="caret"></span>
						</button>
						<ul class="dropdown-menu scrollable-menu">
							<c:forEach var="u" items="${chapter}">
								<c:choose>
									<c:when test="${u.idChapter==content.idChapter}">
        							<a href="chapter/${truyen.idTruyen}/${u.idChapter}.htm"><li class="list-group-item active">${u.tenChapter}</li></a>
									</c:when>
									<c:otherwise>
      								<a href="chapter/${truyen.idTruyen}/${u.idChapter}.htm"><li class="list-group-item">${u.tenChapter}</li></a>
									</c:otherwise>
								</c:choose>
								
							</c:forEach>
						</ul>
					</div>
					
					
				<c:set var="btnTemp" value="0" />
				
				<c:forEach var="u" items="${chapter}" begin = "0" end = "${btnPrevious+1}" varStatus="count">
				<c:if test="${btnTemp==btnPrevious + 1}">
					<a href="chapter/${truyen.idTruyen}/${u.idChapter}.htm"><button type="button" class="btn btn-default" style="margin-left: 5px !important"><i class="zmdi zmdi-arrow-right"></i></button></a>
					</c:if>
					<c:set var="btnTemp" value="${count.count}" />
					</c:forEach>
				
				
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
									<a href="home.htm"> <img src="images/logo/3.png"
										alt="logo">
									</a>
									<p>There are many variations of passages of Lorem Ipsum
										available, but the majority have suffered duskam alteration
										variations of passages</p>
								</div>
								<div class="footer__content">
									<ul
										class="social__net social__net--2 d-flex justify-content-center">
										<li><a href="#"><i class="bi bi-facebook"></i></a></li>
										<li><a href="#"><i class="bi bi-google"></i></a></li>
										<li><a href="#"><i class="bi bi-twitter"></i></a></li>
										<li><a href="#"><i class="bi bi-linkedin"></i></a></li>
										<li><a href="#"><i class="bi bi-youtube"></i></a></li>
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
			<div class="copyright__wrapper">
				<div class="container">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="copyright">
								<div class="copy__right__inner text-left">
									<p>
										Copyright <i class="fa fa-copyright"></i> <a
											href="https://freethemescloud.com/">Free themes Cloud.</a>
										All Rights Reserved
									</p>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="payment text-right">
								<img src="images/icons/payment.png" alt="" />
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