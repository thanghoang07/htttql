package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.NhanSu;
import model.SanPham;

public class SanPhamDAO implements ISanPham {
	private static ConnectionPool pool;

	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	@Override
	public void themSanPham(SanPham sp) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "INSERT INTO SANPHAM VALUES(?,?,?,?,?,?,?);";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ps.setString(1, sp.getMaSP());
		ps.setString(2, sp.getTen());
		ps.setInt(3, sp.getSoLuong());
		ps.setDouble(4, sp.getGia());
		ps.setString(5, sp.getKichThuoc());
		ps.setString(6, sp.getMaLoaiHang());
		ps.setString(7, sp.getUrlHinh());

		ps.executeUpdate();

		con.close();

	}

	@Override
	public ArrayList<SanPham> layDanhSachSanPhamTheoMaLoaiHang(String ma_loaihang)
			throws ClassNotFoundException, SQLException {

		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		String sql = "SELECT * FROM SANPHAM where MA_LH='" + ma_loaihang + "'";
		ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			String ma_sp = rs.getString("MA_SP");
			String ten_sp = rs.getString("TEN_SP");
			int soluong = rs.getInt("SO_LUONG");
			double gia = rs.getDouble("GIA");
			String kichthuoc = rs.getString("KICH_THUOC");
			String maloaihang = rs.getString("MA_LH");
			String url_hinh = rs.getString("URL_HINH");
			// listSanPham.add(new SanPham(ma_sp, ten_sp, soluong, gia, kichthuoc,
			// maloaihang, url_hinh));
		}

		con.close();
		return listSanPham;
	}

}
