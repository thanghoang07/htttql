package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KhachHang;

public class KhachHangDAO implements IKhachHang {

	private static ConnectionPool pool;

	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	@Override
	public void addKhachHang(KhachHang kh) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "insert into KHACHHANG values(?,?,?,?,?);";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ps.setString(1, kh.getMa_kh());
		ps.setString(2, kh.getTen_kh());
		ps.setBoolean(3, kh.isGioitinh());
		ps.setString(4, kh.getDiachi());
		ps.setInt(5, kh.getSdt());

		ps.executeUpdate();

		con.close();

	}

	@Override
	public List<KhachHang> getListKhachHang() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		List<KhachHang> listKhachHang = new ArrayList<KhachHang>();

		String sql = "SELECT * FROM KHACHHANG;";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			String ma_kh = rs.getString("MA_KH");
			String ten_kh = rs.getString("TEN_KH");
			boolean gioitinh = rs.getBoolean("GIOI_TINH");
			String diachi = rs.getString("DIA_CHI");
			int sdt = rs.getInt("SDT");

			listKhachHang.add(new KhachHang(ma_kh, ten_kh, gioitinh, diachi, sdt));
		}

		con.close();

		return listKhachHang;
	}

	@Override
	public void hidenKhachHang(String ma_kh) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub

	}

	@Override
	public KhachHang getKhachHang(String maKhachHang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "Select * from KHACHHANG where MA_KH='" + maKhachHang + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		String ma_kh = null, ten_kh = null;
		boolean gioitinh = false;
		String diachi = null;
		int sdt = 0;

		while (rs.next()) {

			ma_kh = rs.getString("MA_KH");
			ten_kh = rs.getString("TEN_KH");
			gioitinh = rs.getBoolean("GIOI_TINH");
			diachi = rs.getString("DIA_CHI");
			sdt = rs.getInt("SDT");
		}

		con.close();

		return new KhachHang(ma_kh, ten_kh, gioitinh, diachi, sdt);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		IKhachHang ikh = new KhachHangDAO();
		KhachHang kh = ikh.getKhachHang("01");
		System.out.println(kh.toString());
	}

	@Override
	public String getMaKhachHang() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		String sql = "Select MA_KH from KHACHHANG;";
		//
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//
		String ma_kh = null;
		//
		while (rs.next()) {
			ma_kh = rs.getString("MA_KH");
		}
		con.close();
		return ma_kh;
	}

}
