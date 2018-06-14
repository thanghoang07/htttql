<%@page import="model.NhaCungCap"%>
<%@page import="dao.NhaCungCapDAO"%>
<%@page import="dao.INhaCungCap"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chi tiết nhà cung cấp</title>
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
						<h1 class="page-header">Chi tiết nhà cung cấp</h1>
						<br>
						<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="../index.jsp">Tổng
									quan</a></li>
							<li class="breadcrumb-item" aria-current="page"><a
								href="../nhaSanXuat.jsp">Nhà cung cấp</a></li>
							<li class="breadcrumb-item active" aria-current="page">Chi
								tiết nhà cung cấp</li>
						</ol>
						</nav>
					</div>
				</div>
				<%
					INhaCungCap iNhaCungCap = new NhaCungCapDAO();
					NhaCungCap ncc = iNhaCungCap.getNhaCungCap(request.getParameter("maNhaCungCap"));
				%>
				<div class="card mb-3">
					<div class="card-body">
						<h5 class="card-title"><%=ncc.getTen()%></h5>
						<dl class="row">
							<dt class="text-primary col-sm-4 font-weight-bold">Mã nhà
								cung cấp:</dt>
							<dd class="col-sm-8"><%=ncc.getMaNCC()%></dd>
							<dt class="text-primary col-sm-4 font-weight-bold">Email:</dt>
							<dd class="col-sm-8"><%=ncc.getEmail()%></dd>
							<dt class="text-primary col-sm-4 font-weight-bold">Địa chỉ:</dt>
							<dd class="col-sm-8"><%=ncc.getDiaChi()%></dd>
							<dt class="text-primary col-sm-4 font-weight-bold">Số điện
								thoại:</dt>
							<dd class="col-sm-8"><%=ncc.getDienThoai()%></dd>
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