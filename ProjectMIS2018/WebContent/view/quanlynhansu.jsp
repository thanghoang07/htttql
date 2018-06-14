<%@page import="model.NhanSu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.NhanSuDAO"%>
<%@page import="dao.INhanSu"%>
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
<title>Quản lý nhân sự nhân viên</title>
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
						<br>
						<h1 class="page-header">Quản lý nhân sự</h1>
						<br>
						<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="../index.jsp">Tổng
									quan</a></li>
							<li class="breadcrumb-item active" aria-current="page">Nhân
								sự</li>
						</ol>
						</nav>
					</div>
				</div>
				<div>
					<center>
						<a href="themNhanSu.jsp" class="btn btn-primary">Thêm nhân sự
							mới</a>
					</center>
				</div>
				<br>
				<!-- /.row -->
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>STT</th>
								<th>Loại nhân sự</th>
								<th>Tên</th>
								<th>Ngày vào làm</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
								INhanSu iNhanSu = new NhanSuDAO();
													int count = 0;
													List<NhanSu> listNhanSu = iNhanSu.getListNhanSuTheoLoaiNhanSu(request.getParameter("maLoaiNS"));
													for (NhanSu ns : listNhanSu) {
														count++;
							%>
							<tr>
								<td><%=count%></td>
								<td><%=ns.getLoai().getTen_loains()%></td>
								<td><%=ns.getTenNS()%></td>
								<td><%=ns.getNgayVaoLam()%></td>
								<td>
									<div class="btn-group" role="group" aria-label="Basic example">
										<a class="btn btn-outline-info"
											href="chiTietNhanSu.jsp?maNhanSu=<%=ns.getMaNS()%>"> <i
											class="material-icons">insert_drive_file</i>
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