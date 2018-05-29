<%@page import="java.text.DecimalFormat"%>
<%@page import="model.SanPham"%>
<%@page import="java.awt.image.SampleModel"%>
<%@page import="model.DonHang"%>
<%@page import="dao.DonHangDAO"%>
<%@page import="dao.IDonHang"%>
<%@page import="model.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.IKhachHang"%>
<%@page import="dao.KhachHangDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Chi tiết sản phẩm</title>
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
						<h1 class="page-header">Chi Tiết Sản Phẩm</h1>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="../index.jsp">Tổng
									quan</a></li>
							<li class="breadcrumb-item" aria-current="page"><a
								href="../quanlysanpham.jsp">Sản phẩm</a></li>
							<li class="breadcrumb-item active" aria-current="page">Chi
								tiết sản phẩm</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<div class="table-responsive">
					<%
						IDonHang iDonHang = new DonHangDAO();
						SanPham sanPham = iDonHang.getSanPham(request.getParameter("maSanPham"));
					%>
					<div class="card mb-3">
						<div class="card-body">
							<h5 class="card-title"><%=sanPham.getTen()%></h5>
							<dl class="row">
								<dt class="text-primary col-sm-4 font-weight-bold">Mã sản
									phẩm:</dt>
								<dd class="col-sm-8"><%=sanPham.getMaSP()%></dd>
								<dt class="text-primary col-sm-4 font-weight-bold">Giá:</dt>
								<dd class="col-sm-8"><%=new DecimalFormat("#,###,###").format(sanPham.getGia())%></dd>
								<dt class="text-primary col-sm-4 font-weight-bold">Kích
									thước:</dt>
								<dd class="col-sm-8"><%=sanPham.getKichThuoc()%></dd>
								<dt class="text-primary col-sm-4 font-weight-bold">Số
									lượng:</dt>
								<dd class="col-sm-8"><%=sanPham.getSoLuong()%></dd>
							</dl>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
</html>