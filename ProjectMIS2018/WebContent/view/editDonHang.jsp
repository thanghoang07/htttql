<%@page import="java.util.Map.Entry"%>
<%@page import="model.DonHang"%>
<%@page import="dao.DonHangDAO"%>
<%@page import="dao.KhachHangDAO"%>
<%@page import="dao.NhanSuDAO"%>
<%@page import="model.SanPham"%>
<%@page import="model.KhachHang"%>
<%@page import="model.NhanSu"%>
<%@page import="dao.IDonHang"%>
<%@page import="dao.IKhachHang"%>
<%@page import="dao.INhanSu"%>
<%@page import="model.NguyenLieu"%>
<%@page import="dao.NhaCungCapDAO"%>
<%@page import="dao.NguyenLieuDAO"%>
<%@page import="model.LoaiNguyenLieu"%>
<%@page import="model.NhaCungCap"%>
<%@page import="java.util.List"%>
<%@page import="dao.INhaCungCap"%>
<%@page import="dao.INguyenLieu"%>
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
<title>Chỉnh sửa đơn hàng</title>
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
	<div class="col-md-9 md-col">
		<div class="col-md">
			<div class="top-content">
				<div class="white">
					<div id="demo3">
						<form action="<%=request.getContextPath()%>/themDHController"
							method="post">
							<div class="col-md-12">
								<h3>Chỉnh sửa đơn hàng</h3>
							</div>
							<%
								INhanSu iNhanSu = new NhanSuDAO();
								IKhachHang iKhachHang = new KhachHangDAO();
								IDonHang iDonHang = new DonHangDAO();
								DonHang donHang = iDonHang.getDonHang(request.getParameter("maDonHang"));
								List<NhanSu> listNhanSu = iNhanSu.getListNhanSuTheoLoaiNhanSu("KD");
								List<KhachHang> listKhachHang = iKhachHang.getListKhachHang();
								List<SanPham> listSanPham = iDonHang.getListSanPham();
							%>
							<div class="form-group">
								<label for="exampleInputPassword1">Mã</label> <input
									type="hidden" class="form-control" id="maDonHang"
									name="maDonHang" value="<%=donHang.getMaDH()%>"><%=donHang.getMaDH()%>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Nhân viên kinh doanh</label> <input
									type="text" class="form-control" id="maDonHang" name="maNS"
									value="<%=donHang.getNhanVienKD().getMaNS()%>"><%=donHang.getNhanVienKD().getTenNS()%>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Khách hàng</label> <input
									type="text" class="form-control" id="maDonHang" name="maKH"
									value="<%=donHang.getKhachHang().getMa_kh()%>"><%=donHang.getKhachHang().getTen_kh()%>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Ngày nhận</label> <input
									type="date" class="form-control" id="soLuong" name="ngayNhan"
									value="<%=donHang.getNgayNhan()%>"><%=donHang.getNgayNhan()%>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Ngày giao</label><input
									type="date" class="form-control" id="soLuong" name="ngayGiao"
									value="<%=donHang.getNgayGiao()%>"><%=donHang.getNgayGiao()%>
							</div>
							<%
								int count = 0;
								for (Entry<SanPham, Integer> entry : donHang.getChiTietDonHang().getSanPhamSoLuong().entrySet()) {
									count++;
							%>
							<div class="form-group">
								<label for="exampleInputPassword1">Sản phẩm <%=count%></label><input
									type="text" class="form-control" id="soLuong"
									name="maSP<%=count%>" value="<%=entry.getKey().getMaSP()%>"
									placeholder="<%=entry.getKey().getTen()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số lượng</label> <input
									type="text" class="form-control" id="soLuong"
									name="soLuong<%=count%>" placeholder="Số Lượng sản phẩm 1"
									value="<%=entry.getValue()%>">
							</div>
							<%
								}
							%>
							<input type="submit" class="btn btn-primary" value="Tạo">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>