<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map.Entry"%>
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
<title>Chi tiết đơn hàng</title>
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
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<jsp:include page="menu.jsp" />
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<br>
					<h1 class="page-header">Chi tiết đơn hàng</h1>
					<br>
					<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="../index.jsp">Tổng
								quan</a></li>
						<li class="breadcrumb-item" aria-current="page"><a
							href="../donHang.jsp">Đơn hàng</a></li>
						<li class="breadcrumb-item active" aria-current="page">Chi
							tiết đơn hàng</li>
					</ol>
					</nav>
				</div>
				<!-- /.row -->
				<div class="table-responsive">
					<%
						IDonHang iDonHang = new DonHangDAO();
						int count = 0;
						DonHang donHang = iDonHang.getDonHang(request.getParameter("maDonHang"));
						HashMap<SanPham, Integer> ctdh = donHang.getChiTietDonHang().getSanPhamSoLuong();
					%>
					<div>
						<div class="col-lg-12">
							<h3 class="page-header">
								<%=donHang.getMaDH()%>
							</h3>
						</div>
						<br>
						<div class="col-lg-12">
							<h4 class="page-header">
								Tổng tiền:
								<%=new DecimalFormat("#,###,###").format(donHang.getTongTien())%></h4>
						</div>
					</div>
					<br>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên</th>
								<th>Giá</th>
								<th>Kích thước</th>
								<th></th>
							</tr>
						</thead>
						<%
							for (Entry<SanPham, Integer> entry : ctdh.entrySet()) {
								count++;
						%>
						<tbody>
							<tr>
								<td><%=count%></td>
								<td><%=entry.getKey().getTen()%></td>
								<td><%=new DecimalFormat("#,###,###").format(entry.getKey().getGia())%></td>
								<td><%=entry.getKey().getKichThuoc()%></td>
								<td><a class="btn btn-outline-info"
									href="chiTietSanPham.jsp?maSanPham=<%=entry.getKey().getMaSP()%>">Chi
										tiết</a></td>
							</tr>
						</tbody>
						<%
							}
						%>
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