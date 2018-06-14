<%@page import="dao.ThongKeSoLuongDonHang"%>
<%@page import="dao.ThongKe"%>
<%@page import="feature.TongTienDonHang"%>
<%@page import="jdk.nashorn.internal.ir.Labels"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Thong ke bieu do</title>
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
<script src="https://www.chartjs.org/dist/2.7.2/Chart.bundle.js"></script>
<style type="text/css">/* Chart.js */
@
-webkit-keyframes chartjs-render-animation {
	from {opacity: 0.99
}

to {
	opacity: 1
}

}
@
keyframes chartjs-render-animation {
	from {opacity: 0.99
}

to {
	opacity: 1
}

}
.chartjs-render-monitor {
	-webkit-animation: chartjs-render-animation 0.001s;
	animation: chartjs-render-animation 0.001s;
}
</style>
<style>
canvas {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
}
</style>
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
						<h1 class="page-header">Thống kê só lượng đơn hàng</h1>
						<br>
					</div>
				</div>
				<%
					ThongKeSoLuongDonHang tk = new ThongKeSoLuongDonHang();
					List<String> listMaDonHang = tk.layMAKH();
					List<Integer> listSoLuongDonHang = new ArrayList<Integer>();
					for (String makh : listMaDonHang) {
						int soluong = tk.thongKeDonHangTheoDanhSachMKH(makh);
						listSoLuongDonHang.add(soluong);
					}
				%>
				<div style="width: 40%;">
					<div class="chartjs-size-monitor"
						style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
						<div class="chartjs-size-monitor-expand"
							style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
							<div
								style="position: absolute; width: 1000000px; height: 1000000px; left: 0; top: 0"></div>
						</div>
						<div class="chartjs-size-monitor-shrink"
							style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
							<div
								style="position: absolute; width: 200%; height: 200%; left: 0; top: 0"></div>
						</div>
					</div>
					<canvas id="myChart" width="596" height="298"
						class="chartjs-render-monitor"
						style="display: block; width: 596px; height: 298px;"></canvas>
				</div>
				<script type="text/javascript">
					var soLuongDonHang =
				<%=listSoLuongDonHang%>
					;
					var makh =
				<%=listMaDonHang%>
					;
					var ctx = document.getElementById('myChart').getContext(
							'2d');
					var chart = new Chart(ctx, {
						// The type of chart we want to create
						type : 'bar',
						// The data for our dataset
						data : {
							labels : makh,
							datasets : [ {
								label : "Số lượng đơn hàng",
								backgroundColor : 'rgb(255, 0, 10)',
								borderColor : 'rgb(255, 0, 10)',
								data : soLuongDonHang,
							} ]
						},

						options : {
							responsive : true,
							title : {
								display : true,
								text : 'Chart.js Line Chart'
							},
							tooltips : {
								mode : 'index',
								intersect : false,
							},
							hover : {
								mode : 'nearest',
								intersect : true
							},
							scales : {
								xAxes : [ {
									display : true,
									scaleLabel : {
										display : true,
										labelString : 'Month'
									}
								} ],
								yAxes : [ {
									display : true,
									scaleLabel : {
										display : true,
										labelString : 'Value'
									},
									ticks : {
										min : 0,
										max : 100,

										// forces step size to be 5 units
										stepSize : 20
									}
								} ]
							}
						}
					});
				</script>
			</div>
			<div>
				<%
					TongTienDonHang tongTien = new TongTienDonHang();
					List<String> listKhachHang = tk.layMAKH();
					List<Float> listTongTien = new ArrayList<Float>();
					for (String makh : listKhachHang) {
						listTongTien.add(tongTien.tongTienTongDonHangTheoKhachHang(makh));
					}
				%>
				<div style="width: 40%;">
					<div class="chartjs-size-monitor"
						style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
						<div class="chartjs-size-monitor-expand"
							style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
							<div
								style="position: absolute; width: 1000000px; height: 1000000px; left: 0; top: 0"></div>
						</div>
						<div class="chartjs-size-monitor-shrink"
							style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
							<div
								style="position: absolute; width: 200%; height: 200%; left: 0; top: 0"></div>
						</div>
					</div>
					<canvas id="myChart1" width="596" height="298" LW7EYQAVZ
						class="chartjs-render-monitor"
						style="display: block; width: 596px; height: 298px;"></canvas>
				</div>
				<script type="text/javascript">
					var soLuongDonHang =
				<%=listTongTien%>
					;
					var makh =
				<%=listKhachHang%>
					;
					var ctx = document.getElementById('myChart1').getContext(
							'2d');
					var chart = new Chart(ctx, {
						// The type of chart we want to create
						type : 'bar',
						// The data for our dataset
						data : {
							labels : makh,
							datasets : [ {
								label : "Tong tien",
								backgroundColor : 'rgb(255, 0, 10)',
								borderColor : 'rgb(255, 0, 10)',
								data : soLuongDonHang,
							} ]
						},

						options : {
							responsive : true,
							title : {
								display : true,
								text : 'Chart.js Line Chart'
							},
							tooltips : {
								mode : 'index',
								intersect : false,
							},
							hover : {
								mode : 'nearest',
								intersect : true
							},
							scales : {
								xAxes : [ {
									display : true,
									scaleLabel : {
										display : true,
										labelString : 'Khach hang'
									}
								} ],
								yAxes : [ {
									display : true,
									scaleLabel : {
										display : true,
										labelString : 'Tong tien'
									},
									ticks : {
										min : 0,
										max : 100000000,
										// forces step size to be 5 units
										stepSize : 20000000
									}
								} ]
							}
						}
					});
				</script>
			</div>
			<div>
				<%
					float tongTTKH = tongTien.tongTienTongDoanhThuTheoTongKhachHang();
				%>
				<div style="width: 40%;">
					<div class="chartjs-size-monitor"
						style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
						<div class="chartjs-size-monitor-expand"
							style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
							<div
								style="position: absolute; width: 1000000px; height: 1000000px; left: 0; top: 0"></div>
						</div>
						<div class="chartjs-size-monitor-shrink"
							style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
							<div
								style="position: absolute; width: 200%; height: 200%; left: 0; top: 0"></div>
						</div>
					</div>
					<canvas id="myChart2" width="596" height="298"
						class="chartjs-render-monitor"
						style="display: block; width: 596px; height: 298px;"></canvas>
				</div>
				<script type="text/javascript">
					var soLuongDonHang =
				<%=tongTTKH%>
					;
					var makh = "khachHang";
					var ctx = document.getElementById('myChart2').getContext(
							'2d');
					var chart = new Chart(ctx, {
						// The type of chart we want to create
						type : 'bar',
						// The data for our dataset
						data : {
							labels : makh,
							datasets : [ {
								label : "Tong tien",
								backgroundColor : 'rgb(255, 0, 10)',
								borderColor : 'rgb(255, 0, 10)',
								data : soLuongDonHang,
							} ]
						},

						options : {
							responsive : true,
							title : {
								display : true,
								text : 'Chart.js Line Chart'
							},
							tooltips : {
								mode : 'index',
								intersect : false,
							},
							hover : {
								mode : 'nearest',
								intersect : true
							},
							scales : {
								xAxes : [ {
									display : true,
									scaleLabel : {
										display : true,
										labelString : 'Khach hang'
									}
								} ],
								yAxes : [ {
									display : true,
									scaleLabel : {
										display : true,
										labelString : 'Tong tien'
									},
									ticks : {
										min : 0,
										max : 100000000,
										// forces step size to be 5 units
										stepSize : 20000000
									}
								} ]
							}
						}
					});
				</script>
			</div>
		</div>
	</div>
</body>
</html>