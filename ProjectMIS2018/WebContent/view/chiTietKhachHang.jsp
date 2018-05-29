<%@page import="dao.KhachHangDAO"%>
<%@page import="dao.IKhachHang"%>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chi tiết khách hàng</title>
<!--  -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<jsp:include page="menu.jsp" />
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<br>
						<h1 class="page-header">Chi tiết khách hàng</h1>
						<br>
						<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="../index.jsp">Tổng
									quan</a></li>
							<li class="breadcrumb-item" aria-current="page"><a
								href="../khachhang.jsp">Khách hàng</a></li>
							<li class="breadcrumb-item active" aria-current="page">Chi
								tiết khách hàng</li>
						</ol>
						</nav>
					</div>
				</div>
				<%
					IKhachHang iKhachHang = new KhachHangDAO();
					KhachHang khachHang = iKhachHang.getKhachHang(request.getParameter("maKhachHang"));
				%>
				<div class="card mb-3">
					<div class="card-body">
						<h5 class="card-title"><%=khachHang.getTen_kh()%></h5>
						<dl class="row">
							<dt class="text-primary col-sm-4 font-weight-bold">Mã khách
								hàng:</dt>
							<dd class="col-sm-8"><%=khachHang.getMa_kh()%></dd>
							<dt class="text-primary col-sm-4 font-weight-bold">Giới
								tính:</dt>
							<dd class="col-sm-8"><%=khachHang.isGioitinh() ? "Nam" : "Nữ"%></dd>
							<dt class="text-primary col-sm-4 font-weight-bold">Địa chỉ:</dt>
							<dd class="col-sm-8"><%=khachHang.getDiachi()%></dd>
							<dt class="text-primary col-sm-4 font-weight-bold">Số điện
								thoại:</dt>
							<dd class="col-sm-8"><%=khachHang.getSdt()%></dd>
						</dl>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
</html>