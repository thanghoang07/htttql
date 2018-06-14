<%@page import="model.LoaiHang"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.IDonHang"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.DonHangDAO"%>
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
<title>Quản lý sản phẩm</title>
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
		<!-- the end MENU -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Quản lý sản phẩm</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="../index.jsp">Tổng
									quan</a></li>
							<li class="active"><i class="fa fa-edit"></i> Sản phẩm</li>
							<li class="active"><i class="#"></i> Bàn</li>
						</ol>
					</div>
				</div>
				<div>
					<button type="button" class="btn btn-info btn-secondary"
						data-toggle="collapse" data-target="#demo3">
						<span class="glyphicon glyphicon-plus">&nbsp;Thêm sản phẩm
							mới</span>
					</button>
					<div id="demo3" class="collapse">
						<form action="<%=request.getContextPath()%>/themSPController"
							method="post">
							<div class="col-md-12">
								<h3>Thêm sản phẩm mới</h3>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Tên</label> <input
									type="text" class="form-control" id="tenSP" name="tenSP"
									placeholder="Tên sản phẩm ">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số lượng</label> <input
									type="text" class="form-control" id="soLuong" name="soLuong"
									placeholder="Số Lượng">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Giá</label> <input
									type="text" class="form-control" id="gia" name="gia"
									placeholder="Giá">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Kích thước</label> <input
									type="text" class="form-control" id="kichThuoc"
									name="kichThuoc" placeholder="Kích thước">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Loại hàng</label>
								<%
									IDonHang iDonHang = new DonHangDAO();
									List<SanPham> listSanPham = iDonHang.getListSanPham(request.getParameter("maLoaiHang"));
									List<LoaiHang> listLNL = iDonHang.getListLoaiHang();
								%>
								<select class="form-control" id="exampleSelect2"
									name="maLoaiHang">
									<%
										for (int k = 0; k < listLNL.size(); k++) {
											String ma = listLNL.get(k).getMa_loaihang();
											String name = listLNL.get(k).getTen_loaihang();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Hình ảnh</label> <input
									type="text" class="form-control" id="hinh" name="hinh"
									placeholder="Đường dẫn hình">
							</div>
							<input type="submit" class="btn btn-primary" value="Tạo">
						</form>
					</div>
				</div>
				<br>
				<!-- /.row -->
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên</th>
								<th>Số lượng</th>
								<th>Đơn giá</th>
								<th>Kích thước</th>
								<th>Loại</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
								for (SanPham sp : listSanPham) {
							%>
							<tr>
								<td><%=sp.getMaSP()%></td>
								<td><%=sp.getTen()%></td>
								<td><%=sp.getSoLuong()%></td>
								<td><%=new DecimalFormat("#,###,###").format(sp.getGia())%></td>
								<td><%=sp.getKichThuoc()%></td>
								<td><%=sp.getLoaiHang().getTen_loaihang()%></td>
								<td>
									<div class="btn-group" role="group" aria-label="Basic example">
										<a class="btn btn-outline-info"
											href="<%=request.getContextPath()%>/view/chiTietSanPham.jsp?maSanPham=<%=sp.getMaSP()%>"> <i
											class="material-icons">insert_drive_file</i>
										</a> <a href="<%=request.getContextPath()%>/view/editSanPham.jsp?maSanPham=<%=sp.getMaSP()%>"
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
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
</html>