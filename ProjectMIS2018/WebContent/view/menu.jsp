<%@page import="model.LoaiHang"%>
<%@page import="dao.QuanLyLoaiHangDAO"%>
<%@page import="dao.IQuanLyLoaiHang"%>
<%@page import="model.LoaiNhanSu"%>
<%@page import="model.LoaiHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.QuanLyNhanSuDAO"%>
<%@page import="dao.IQuanLyNhanSu"%>
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

<title>Menu</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary"> <a
		class="navbar-brand" href="#">Project-HTTT</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Tổng
					quan<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link" href="#">Thống
					kê chi tiết</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="donHang.jsp">Đơn hàng</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="khachhang.jsp">Khách hàng</a></li>
			<li class="nav-item active dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Sản phẩm</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<%
						IQuanLyLoaiHang qllh = new QuanLyLoaiHangDAO();
						List<LoaiHang> listLoaiHang = new ArrayList<LoaiHang>();
						listLoaiHang = qllh.getList();
						for (LoaiHang lh : listLoaiHang) {
					%>
					<a class="dropdown-item"
						href="quanlysanpham.jsp?maLoaiHang=<%=lh.getMa_loaihang()%>"><%=lh.getTen_loaihang()%></a>
					<div class="dropdown-divider"></div>
					<%
						}
					%>
				</div></li>
			<li class="nav-item active dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Nhân sự </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<%
						IQuanLyNhanSu ql = new QuanLyNhanSuDAO();
						List<LoaiNhanSu> listLoaiNhanSu = new ArrayList<LoaiNhanSu>();
						listLoaiNhanSu = ql.getList();
						for (LoaiNhanSu lns : listLoaiNhanSu) {
					%>
					<a class="dropdown-item"
						href="quanlynhansu.jsp?maLoaiNS=<%=lns.getMa_loains()%>"><%=lns.getTen_loains()%></a>
					<div class="dropdown-divider"></div>
					<%
						}
					%>
				</div></li>
			<li class="nav-item active"><a class="nav-link"
				href="nguyenLieu.jsp">Nguyên liệu</a>
			<li class="nav-item active"><a class="nav-link" href="#">Chấm
					công</a></li>
		</ul>
		<span class="navbar-text">
			<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Đăng
				xuất</button>
		</span>
	</div>
	</nav>
</body>
</html>