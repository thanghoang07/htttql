<%@page import="model.NhaCungCap"%>
<%@page import="dao.NhaCungCapDAO"%>
<%@page import="dao.INhaCungCap"%>
<%@page import="model.LoaiNguyenLieu"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.NguyenLieu"%>
<%@page import="java.util.List"%>
<%@page import="dao.INguyenLieu"%>
<%@page import="dao.NguyenLieuDAO"%>
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
<title>Nguyên liệu</title>
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
						<h1 class="page-header">Quản lý nguyên liệu</h1>
						<br>
						<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="../index.jsp">Tổng
									quan</a></li>
							<li class="breadcrumb-item active" aria-current="page">Nguyên
								liệu</li>
						</ol>
						</nav>
					</div>
				</div>
				<div>
					<button type="button" class="btn btn-info btn-secondary"
						data-toggle="collapse" data-target="#demo3">
						<span class="glyphicon glyphicon-plus">&nbsp;Thêm nguyên
							liệu mới</span>
					</button>
					<div id="demo3" class="collapse">
						<form action="<%=request.getContextPath()%>/themNLieuController"
							method="post">
							<div class="col-md-12">
								<h3>Thêm nguyên liệu cấp mới</h3>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Mã</label> <input type="text"
									class="form-control" id="maNL" name="maNL"
									placeholder="Mã nguyên liệu">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Tên</label> <input
									type="text" class="form-control" id="tenNL" name="tenNL"
									placeholder="Tên nguyên liệu">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số lượng</label> <input
									type="text" class="form-control" id="soLuong" name="soLuong"
									placeholder="Số Lượng">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Loại nguyên liệu</label>
								<%
									INguyenLieu iNguyenLieu = new NguyenLieuDAO();
									INhaCungCap iNhaCungCap = new NhaCungCapDAO();
									List<NhaCungCap> listNCC = iNhaCungCap.getListNhaCungCap();
									List<LoaiNguyenLieu> listLNL = iNguyenLieu.getListLoaiNguyenLieu();
								%>
								<select class="form-control" id="exampleSelect2" name="maLoaiNL">
									<%
										for (int k = 0; k < listLNL.size(); k++) {
											String ma = listLNL.get(k).getMa();
											String name = listLNL.get(k).getTen();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Nhà cung cấp</label><select
									class="form-control" id="exampleSelect2" name="maNCC">
									<%
										for (int k = 0; k < listNCC.size(); k++) {
											String ma = listNCC.get(k).getMaNCC();
											String name = listNCC.get(k).getTen();
									%>
									<option value="<%=ma%>"><%=name%></option>
									<%
										}
									%>
								</select>
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
								<th>STT</th>
								<th>Mã nguyên liệu</th>
								<th>Tên nguyên liệu</th>
								<th>Số lượng</th>
								<th>Loại nguyên liệu</th>
								<th>Nhà cung cấp</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
								INguyenLieu ngl = new NguyenLieuDAO();
								int count = 0;
								List<NguyenLieu> listNguyenLieu = new ArrayList<NguyenLieu>();
								listNguyenLieu = ngl.getList();
								for (NguyenLieu nl : listNguyenLieu) {
									count++;
							%>
							<tr>
								<td><%=count%></td>
								<td><%=nl.getMaNL()%></td>
								<td><%=nl.getTen()%></td>
								<td><%=nl.getSoLuong()%></td>
								<td><%=nl.getLoai().getTen()%></td>
								<td><a
									href="<%=request.getContextPath()%>/view/chiTietNhaCungCap.jsp?maNhaCungCap=<%=nl.getNhaCungCap().getMaNCC()%>"><%=nl.getNhaCungCap().getTen()%></a></td>
								<td><a
									href="<%=request.getContextPath()%>/view/editNguyenLieu.jsp?maNguyenLieu=<%=nl.getMaNL()%>"
									class="btn btn-outline-warning"> <i class="material-icons">edit</i></a>
									<a href="#" class="btn btn-outline-danger"> <i
										class="material-icons">delete_sweep</i></a></td>
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