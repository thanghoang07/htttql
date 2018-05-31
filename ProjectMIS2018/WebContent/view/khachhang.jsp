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
<title>Khách hàng</title>
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
						<h1 class="page-header">Quản lý khách hàng</h1>
						<br>
						<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="../index.jsp">Tổng
									quan</a></li>
							<li class="breadcrumb-item active" aria-current="page">Khách
								hàng</li>
						</ol>
						</nav>
					</div>
				</div>
				<div>
					<center>
						<button type="button" class="btn btn-info btn-secondary"
							data-toggle="collapse" data-target="#demo3">
							<span class="glyphicon glyphicon-plus">&nbsp;Thêm nhà
								khách hàng mới</span>
						</button>
					</center>
					<div class="col-sm-2"></div>
					<div id="demo3" class="collapse col-sm-8">
						<form action="<%=request.getContextPath()%>/themKHController"
							method="post">
							<div class="col-md-12">
								<h3>Thêm nhà khách hàng mới</h3>
							</div>
							<div class="col-md-4"></div>
							<div class="col-md-8">
								<div class="form-group">
									<label for="exampleInputPassword1">Tên</label> <input
										type="text" class="form-control" id="tenKH" name="tenKH"
										placeholder="Tên nhà cung cấp">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Địa chỉ</label> <input
										type="text" class="form-control" id="diaChiNCC"
										name="diaChiKH" placeholder="Địa chỉ khách hàng">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Giới tính</label><select
										class="form-control" id="exampleSelect2" name="gioiTinh">
										<option value="true">Nam</option>
										<option value="false">Nữ</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Số điện thoại</label> <input
										type="text" class="form-control" id="soDienThoai"
										name="soDienThoai" placeholder="Số điện thoại">
								</div>
								<center>
									<input type="submit" class="btn btn-primary" value="Tạo">
								</center>
							</div>

							<div class="col-md-4"></div>

						</form>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<br>
				<!-- /.row -->
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>STT</th>
								<th>Họ và tên</th>
								<th>Giới tính</th>
								<th>Địa chỉ</th>
								<th>Số điện thoại</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
								IKhachHang khImpl = new KhachHangDAO();
								int count = 0;
								List<KhachHang> listKH = khImpl.getListKhachHang();
								for (KhachHang kh : listKH) {
									count++;
							%>
							<tr>
								<td><%=count%></td>
								<td><%=kh.getTen_kh()%></td>
								<td><%=kh.isGioitinh() ? "Nam" : "Nữ"%></td>
								<td><%=kh.getDiachi()%></td>
								<td><%="0" + kh.getSdt()%></td>
								<td>
									<div class="btn-group" role="group" aria-label="Basic example">
										<a class="btn btn-outline-info"
											href="chiTietKhachHang.jsp?maKhachHang=<%=kh.getMa_kh()%>">
											<i class="material-icons">insert_drive_file</i>
										</a> <a href="#" class="btn btn-outline-warning"> <i
											class="material-icons">edit</i></a> <a href="#"
											class="btn btn-outline-danger"> <i class="material-icons">delete_sweep</i></a>
									</div>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
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