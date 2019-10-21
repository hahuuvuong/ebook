<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">


<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thêm truyện</title>
<base href="${pageContext.servletContext.contextPath}/">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
<link rel="stylesheet" href="assets/libs/css/style.css">
<link rel="stylesheet"
	href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
</head>

<body>
	<!-- ============================================================== -->
	<!-- main wrapper -->
	<!-- ============================================================== -->
	<div class="dashboard-main-wrapper">
		<!-- ============================================================== -->
		<!-- navbar -->
		<!-- ============================================================== -->
		<div class="dashboard-header">
			<nav class="navbar navbar-expand-lg bg-white fixed-top">
				<a class="navbar-brand" href="../index.html">Concept</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse " id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto navbar-right-top">
                       
                   
                     
                        <li class="nav-item dropdown nav-user">
                            <a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsAUelg7yg0mepGMf-N93hh6E9XrLnKwsKa4YEQ6swhDknk4F9eQ" alt="" class="user-avatar-md rounded-circle"></a>
                            <div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
                                <div class="nav-user-info">
                                    <h5 class="mb-0 text-white nav-user-name">${sessionScope.nickname}</h5>
                                </div>
                                <a class="dropdown-item" href="#"><i class="fas fa-user mr-2"></i>Account</a>
                                <a class="dropdown-item" href="account/logout.htm"><i class="fas fa-power-off mr-2"></i>Logout</a>
                            </div>
                        </li>
                    </ul>
                </div>
			</nav>
		</div>
		<!-- ============================================================== -->
		<!-- end navbar -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- left sidebar -->
		<!-- ============================================================== -->
		<div class="nav-left-sidebar sidebar-dark">
			<div class="menu-list">
				<nav class="navbar navbar-expand-lg navbar-light">
					<a class="d-xl-none d-lg-none" href="#">Dashboard</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarNav" aria-controls="navbarNav"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav flex-column">
							<li class="nav-divider">Menu</li>
							<li class="nav-item "><a class="nav-link active" href="#"
								data-toggle="collapse" aria-expanded="false"
								data-target="#submenu-1" aria-controls="submenu-1"><i
									class="fa fa-fw fa-user-circle"></i>Dashboard <span
									class="badge badge-success">6</span></a>
								<div id="submenu-1" class="collapse submenu" style="">
									<ul class="nav flex-column">
										<li class="nav-item"><a class="nav-link" href="#"
											data-toggle="collapse" aria-expanded="false"
											data-target="#submenu-1-2" aria-controls="submenu-1-2">Thể
												loại</a>
											<div id="submenu-1-2" class="collapse submenu" style="">
												<ul class="nav flex-column">
													<li class="nav-item"><a class="nav-link"
														href="dashboard/theloai.htm">Thêm thể loại</a></li>
											

												</ul>
											</div></li>

										<li class="nav-item"><a class="nav-link" href="#"
											data-toggle="collapse" aria-expanded="false"
											data-target="#submenu-1-1" aria-controls="submenu-1-1">Truyện</a>
											<div id="submenu-1-1" class="collapse submenu" style="">
												<ul class="nav flex-column">
													<li class="nav-item"><a class="nav-link"
														href="addtruyen.htm">Thêm truyện</a></li>
													<li class="nav-item"><a class="nav-link"
														href="inserttruyen/1.htm">Chỉnh sửa truyện</a></li>
												</ul>
											</div></li>
										<li class="nav-item"><a class="nav-link" href="#"
											data-toggle="collapse" aria-expanded="false"
											data-target="#submenu-1-0" aria-controls="submenu-1-0">Chapter</a>
											<div id="submenu-1-0" class="collapse submenu" style="">
												<ul class="nav flex-column">
													<li class="nav-item"><a class="nav-link"
														href="addchapter.htm">Thêm chapter</a></li>
													<li class="nav-item"><a class="nav-link"
														href="insertchapter/1.htm">Chỉnh sửa chapter</a></li>
												</ul>
											</div></li>
									</ul>
								</div></li>

						</ul>
					</div>
				</nav>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- end left sidebar -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- wrapper  -->
		<!-- ============================================================== -->
		<div class="dashboard-wrapper">
			<div class="container-fluid  dashboard-content">
				<!-- ============================================================== -->
				<!-- pageheader -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="page-header">
						
						
						</div>
					</div>
				</div>
				<!-- ============================================================== -->
				<!-- end pageheader -->
				<!-- ============================================================== -->

				<div class="row">
					<!-- ============================================================== -->
					<!-- validation form -->
					<!-- ============================================================== -->
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="card">
							<h5 class="card-header">Nhập truyện</h5>
							<div class="card-body">
								<form:form action = "addtruyen.htm" modelAttribute = "truyen" method="POST" class="needs-validation" >
									<div class="row">
										  <c:if test = "${truyen.idTruyen !=0}">
										  <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
											<label for="validationCustom01">ID truyen</label> <form:input path="idTruyen" type="text" class="form-control" readonly="true"  id="validationCustom01" placeholder="Nhập tên truyện" />
											<div class="valid-feedback">Looks good!</div>
										</div>
										    </c:if>
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
											<label for="validationCustom01">Tên truyện</label> <form:input path="TenTruyen" type="text" class="form-control" id="validationCustom01" placeholder="Nhập tên truyện" />
											<div class="valid-feedback">Looks good!</div>
										</div>
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
											<label for="validationCustom01">Tác giả</label> <form:input path = "TacGia" type="text" class="form-control" id="validationCustom01" placeholder="Nhập tác giả"/>
											<div class="valid-feedback">Looks good!</div>
										</div>
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
											<label for="validationCustom01">Link image</label> <form:input path = "image"
												type="text" class="form-control" id="validationCustom01"
												placeholder="Nhập link image"/>
											<div class="valid-feedback">Looks good!</div>
										</div>
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
											<label for="validationCustom01">Chọn thể loại</label>
										<input value = "${idTheLoai.idTheLoai}" name = "idtTheLoai"
												type="text" class="form-control" list="brow"
												placeholder="Nhập tên truyện" />
											<datalist id="brow">
												<c:forEach var="u" items = "${categories}" >
												<option value="${u.idTheLoai}">${u.tenTheLoai}</option>
												</c:forEach>
											</datalist>
										</div>
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
											<div class="md-form">
												<i class="fas fa-pencil-alt prefix"></i> <label for="form10">Tóm
													tắt</label>
												<form:textarea path = "TomTat" id="form10" class="md-textarea form-control"
													rows="5"></form:textarea>

											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="col-xl-4 col-lg-4 col-md-12 col-sm-12 col-12 mb-2">
										
										</div>


										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
											<button class="btn btn-primary" type="submit">Submit
												form</button>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
					<!-- ============================================================== -->
					<!-- end validation form -->
					<!-- ============================================================== -->
				</div>



			</div>

		</div>
		<!-- ============================================================== -->
		<!-- end main wrapper -->
		<!-- ============================================================== -->
		<!-- Optional JavaScript -->
		<script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
		<script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
		<script src="assets/vendor/parsley/parsley.js"></script>
		<script src="assets/libs/js/main-js.js"></script>
		<script>
			$('#form').parsley();
		</script>
		<script>
			// Example starter JavaScript for disabling form submissions if there are invalid fields
			(function() {
				'use strict';
				window
						.addEventListener(
								'load',
								function() {
									// Fetch all the forms we want to apply custom Bootstrap validation styles to
									var forms = document
											.getElementsByClassName('needs-validation');
									// Loop over them and prevent submission
									var validation = Array.prototype.filter
											.call(
													forms,
													function(form) {
														form
																.addEventListener(
																		'submit',
																		function(
																				event) {
																			if (form
																					.checkValidity() === false) {
																				event
																						.preventDefault();
																				event
																						.stopPropagation();
																			}
																			form.classList
																					.add('was-validated');
																		},
																		false);
													});
								}, false);
			})();
		</script>
</body>

</html>