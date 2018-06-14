package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKe {
	private static ConnectionPool pool;

	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	public List<Float> danhSachTienDonHangMotKhachHang(String maKhachHang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		String sql = "SELECT DONHANG.MA_KH, DONHANG.TONG_TIEN FROM DONHANG INNER JOIN KHACHHANG ON KHACHHANG.MA_KH = DONHANG.MA_KH "
				+ "where DONHANG.MA_KH='" + maKhachHang + "' GROUP BY DONHANG.MA_KH, DONHANG.TONG_TIEN;";
		
		List<Float> listTienDonHang = new ArrayList<Float>();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Float tienDH = rs.getFloat("TONG_TIEN");
			listTienDonHang.add(tienDH);
		}
		
		return listTienDonHang;
	}
	
	public List<Float> danhSachDoanhThuTongKhachHang() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		String sql = "SELECT DONHANG.MA_KH, DONHANG.TONG_TIEN FROM DONHANG INNER JOIN KHACHHANG ON KHACHHANG.MA_KH = DONHANG.MA_KH "
				+" GROUP BY DONHANG.MA_KH, DONHANG.TONG_TIEN;";
		
		List<Float> listTienDonHang = new ArrayList<Float>();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Float tienDH = rs.getFloat("TONG_TIEN");
			listTienDonHang.add(tienDH);
		}
		
		return listTienDonHang;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ThongKe tk = new ThongKe();
		List<Float> list = tk.danhSachTienDonHangMotKhachHang("01");
		for (Float float1 : list) {
			System.out.println(float1.toString());
		}
	}
}
