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
<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../font-awesome-4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
						<h1 class="page-header">Chi Tiết Đơn Hàng</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="../index.jsp">Tổng
									quan</a></li>
							<li class="active"><i class="fa fa-edit"></i> Khách hàng</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<div class="table-responsive">
					<%
						IDonHang iDonHang = new DonHangDAO();
						int count = 0;
						DonHang donHang = iDonHang.getDonHang(request.getParameter("maDonHang"));
					%>
					<div>
						<div class="col-lg-12">
							<h3 class="page-header">
								<%=donHang.getMaDH()%>
							</h3>
						</div>

						<div class="col-lg-12">
							<h4 class="page-header">Sản phẩm</h4>
						</div>
					</div>

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
							List<SanPham> listSP = donHang.getChiTietDonHang().getListSanPham();
							for (int i = 0; i < listSP.size(); i++) {
								count++;
						%>
						<tbody>

							<tr>
								<td><%=count%></td>
								<td><%=listSP.get(i).getTen()%></td>
								<td><%=new DecimalFormat("#,###,###").format(listSP.get(i).getGia())%></td>
								<td><%=listSP.get(i).getKichThuoc()%></td>
								<td><a class="btn btn-outline-info"
									href="chiTietSanPham.jsp?maSanPham=<%=listSP.get(i).getMaSP()%>">Chi
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