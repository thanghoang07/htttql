<%@page import="model.SanPham"%>
<%@page import="model.KhachHang"%>
<%@page import="dao.KhachHangDAO"%>
<%@page import="dao.IKhachHang"%>
<%@page import="model.NhanSu"%>
<%@page import="dao.NhanSuDAO"%>
<%@page import="dao.INhanSu"%>
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
					<button type="button" class="btn btn-info btn-secondary"
						data-toggle="collapse" data-target="#demo3">
						<span class="glyphicon glyphicon-plus">&nbsp;Thêm đơn hàng
							mới</span>
					</button>
					<div id="demo3" class="collapse">
						<form action="<%=request.getContextPath()%>/themDHController"
							method="post">
							<div class="col-md-12">
								<h3>Thêm đơn hàng mới</h3>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Nhân viên kinh doanh</label>
								<%
									INhanSu iNhanSu = new NhanSuDAO();
									IKhachHang iKhachHang = new KhachHangDAO();
									IDonHang iDonHang = new DonHangDAO();
									List<NhanSu> listNhanSu = iNhanSu.getListNhanSuTheoLoaiNhanSu("KD");
									List<KhachHang> listKhachHang = iKhachHang.getListKhachHang();
									List<SanPham> listSanPham = iDonHang.getListSanPham();
								%>
								<select class="form-control" id="exampleSelect2" name="maNS">
									<%
										for (int k = 0; k < listNhanSu.size(); k++) {
											String ma = listNhanSu.get(k).getMaNS();
											String name = listNhanSu.get(k).getTenNS();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Khách hàng</label> <select
									class="form-control" id="exampleSelect2" name="maKH">
									<%
										for (int k = 0; k < listKhachHang.size(); k++) {
											String ma = listKhachHang.get(k).getMa_kh();
											String name = listKhachHang.get(k).getTen_kh();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Ngày nhận</label> <input
									type="date" class="form-control" id="soLuong" name="ngayNhan">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Ngày giao</label><input
									type="date" class="form-control" id="soLuong" name="ngayGiao">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Sản phẩm 1</label><select
									class="form-control" id="exampleSelect2" name="maSP1">
									<%
										for (int k = 0; k < listSanPham.size(); k++) {
											String ma = listSanPham.get(k).getMaSP();
											String name = listSanPham.get(k).getTen();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số lượng</label> <input
									type="text" class="form-control" id="soLuong" name="soLuong1"
									placeholder="Số Lượng sản phẩm 1">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Sản phẩm 2</label><select
									class="form-control" id="exampleSelect2" name="maSP2">
									<%
										for (int k = 0; k < listSanPham.size(); k++) {
											String ma = listSanPham.get(k).getMaSP();
											String name = listSanPham.get(k).getTen();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số lượng</label> <input
									type="text" class="form-control" id="soLuong" name="soLuong2"
									placeholder="Số Lượng sản phẩm 2">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Sản phẩm 3</label><select
									class="form-control" id="exampleSelect2" name="maSP3">
									<%
										for (int k = 0; k < listSanPham.size(); k++) {
											String ma = listSanPham.get(k).getMaSP();
											String name = listSanPham.get(k).getTen();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số lượng</label> <input
									type="text" class="form-control" id="soLuong" name="soLuong3"
									placeholder="Số Lượng sản phẩm 3">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Sản phẩm 4</label><select
									class="form-control" id="exampleSelect2" name="maSP4">
									<%
										for (int k = 0; k < listSanPham.size(); k++) {
											String ma = listSanPham.get(k).getMaSP();
											String name = listSanPham.get(k).getTen();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số lượng</label> <input
									type="text" class="form-control" id="soLuong" name="soLuong4"
									placeholder="Số Lượng sản phẩm 4">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Sản phẩm 5</label><select
									class="form-control" id="exampleSelect2" name="maSP5">
									<%
										for (int k = 0; k < listSanPham.size(); k++) {
											String ma = listSanPham.get(k).getMaSP();
											String name = listSanPham.get(k).getTen();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số lượng</label> <input
									type="text" class="form-control" id="soLuong" name="soLuong5"
									placeholder="Số Lượng sản phẩm 5">
							</div>
							<input type="submit" class="btn btn-primary" value="Tạo">
						</form>
					</div>
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
											href="<%=request.getContextPath()%>/view/chiTietDonHang.jsp?maDonHang=<%=dh.getMaDH()%>">
											<i class="material-icons">insert_drive_file</i>
										</a> <a
											href="<%=request.getContextPath()%>/view/editDonHang.jsp?maDonHang=<%=dh.getMaDH()%>"
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