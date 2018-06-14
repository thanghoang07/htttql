<%@page import="model.LoaiHang"%>
<%@page import="java.util.List"%>
<%@page import="dao.DonHangDAO"%>
<%@page import="model.SanPham"%>
<%@page import="dao.IDonHang"%>
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
<title>Chỉnh sửa sản phẩm</title>
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
					<%
						IDonHang iDonHang = new DonHangDAO();
						List<LoaiHang> listLNL = iDonHang.getListLoaiHang();
						SanPham sanPham = iDonHang.getSanPham(request.getParameter("maSanPham"));
					%>
					<form action="<%=request.getContextPath()%>/suaSPController"
						method="post">
						<table class="form-group">
							<tr>
								<td class="text-info col-sm-3">Mã:</td>
								<td class="col-sm-9"><input type="hidden"
									class="form-control" name="maSP" value="<%=sanPham.getMaSP()%>"
									id="disabledTextInput"><%=sanPham.getMaSP()%></td>
							</tr>
							<tr>
								<td class="text-info col-sm-3">Tên:</td>
								<td class="col-sm-9"><input type="text"
									class="form-control" name="tenSP" value="<%=sanPham.getTen()%>"></td>
							</tr>
							<tr>
								<td class="text-info col-sm-3">Sô lượng</td>
								<td class="col-sm-9"><input type="text"
									class="form-control" name="soLuong"
									value="<%=sanPham.getSoLuong()%>"></td>
							</tr>
							<tr>
								<td class="text-info col-sm-3">Giá</td>
								<td class="col-sm-9"><input type="text"
									class="form-control" name="gia" value="<%=sanPham.getGia()%>"></td>
							</tr>
							<tr>
								<td class="text-info col-sm-3">Kích thước</td>
								<td class="col-sm-9"><input type="text"
									class="form-control" name="kichThuoc"
									value="<%=sanPham.getKichThuoc()%>"></td>
							</tr>
							<tr>
								<td class="text-info col-sm-3">Loại hàng</td>
								<td class="col-sm-9"><select class="form-control"
									id="exampleSelect2" name="maLoaiHang">
										<%
											for (int k = 0; k < listLNL.size(); k++) {
												String ma = listLNL.get(k).getMa_loaihang();
												String name = listLNL.get(k).getTen_loaihang();
										%>
										<option value="<%=ma%>"><%=name%></option>
										<%
											}
										%>
								</select></td>
							</tr>
							<tr>
								<td class="text-info col-sm-3">Đường dẫn hình:</td>
								<td class="col-sm-9"><textarea class="form-control"
										id="textarea" name="hinh" rows="4"><%=sanPham.getUrlHinh()%></textarea>
								</td>
							</tr>
							<tr>
								<td><button type="submit" class="btn btn-outline-warning"
										value="Thêm">Lưu lại</button></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>