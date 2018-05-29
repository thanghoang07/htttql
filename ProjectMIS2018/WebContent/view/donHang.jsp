<%@page import="model.DonHang"%>
<%@page import="java.util.List"%>
<%@page import="dao.DonHangDAO"%>
<%@page import="dao.IDonHang"%>
<%@page import="java.text.DecimalFormat"%>
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
<title>Đơn hàng</title>
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
						<h1 class="page-header">Quản lý đơn hàng</h1>
						<br>
						<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="../index.jsp">Tổng
									quan</a></li>
							<li class="breadcrumb-item active" aria-current="page">Đơn
								hàng</li>
						</ol>
						</nav>
					</div>
				</div>
				<div>
					<center>
						<a href="them_sp.jsp" class="btn btn-primary">Thêm đơn hàng
							mới</a>
					</center>
				</div>
				<br>
				<!-- Table Don hang -->
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>STT</th>
								<th>Mã đơn hàng</th>
								<th>Nhân viên</th>
								<th>Khách hàng</th>
								<th>Tổng tiền</th>
								<th>Ngày nhận</th>
								<th>Ngày giao</th>
								<th>Trạng thái đơn hàng</th>
								<th></th>
								<!-- <th>Nhà sản xuất</th> -->
							</tr>
						</thead>
						<tbody>
							<%
								IDonHang idh = new DonHangDAO();
								int count = 0;
								List<DonHang> listDonHangs = idh.layDanhSachDonHang();
								for (DonHang dh : listDonHangs) {
									count++;
							%>
							<tr>
								<td><%=count%></td>
								<td><%=dh.getMaDH()%></td>
								<td><%=dh.getNhanVienKD().getTenNS()%></td>
								<td><%=dh.getKhachHang().getTen_kh()%></td>
								<td><%=new DecimalFormat("#,###,###").format(dh.getTongTien())%></td>
								<td><%=dh.getNgayNhan()%></td>
								<td><%=dh.getNgayGiao()%></td>
								<td><%=dh.getTrangThai().getTen()%></td>
								<td>
									<div class="btn-group" role="group" aria-label="Basic example">
										<a class="btn btn-outline-info"
											href="chiTietDonHang.jsp?maDonHang=<%=dh.getMaDH()%>"> <i
											class="material-icons">insert_drive_file</i></a> <a href="#"
											class="btn btn-outline-warning"> <i
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
				<br>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-6">
						<h2>Thống kê theo ngày</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>Loại mặt hàng</th>
										<th>Lượng truy cập</th>
										<th>% Lượng truy cập mới</th>
										<th>Doanh thu</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Ghế</td>
										<td>1265</td>
										<td>32.3%</td>
										<td>650.000 VNĐ</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="col-lg-6">
						<h2>Thống kê theo tháng</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>Loại mặt hàng</th>
										<th>Lượng truy cập</th>
										<th>% Lượng truy cập mới</th>
										<th>Doanh thu</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Ghế</td>
										<td>1265</td>
										<td>32.3%</td>
										<td>650.000 VNĐ</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-6">
						<h2>Thống kê theo năm</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Loại mặt hàng</th>
										<th>Lượng truy cập</th>
										<th>% Lượng truy cập mới</th>
										<th>Doanh thu</th>
									</tr>
								</thead>
								<tbody>
									<tr class="active">
										<td>Ghế</td>
										<td>1265</td>
										<td>32.3%</td>
										<td>650.000 VNĐ</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-6">
						<h2>Thống kê theo nhân viên</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Loại mặt hàng</th>
										<th>Mã nhân viên</th>
										<th>Lượng truy cập</th>
										<th>% Lượng truy cập mới</th>
										<th>Doanh thu</th>
									</tr>
								</thead>
								<tbody>
									<tr class="active">
										<td>Ghế</td>
										<td valign="middle" rowspan="3">NV0001</td>
										<td>1265</td>
										<td>32.3%</td>
										<td>650.000 VNĐ</td>
									</tr>
								</tbody>
							</table>
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