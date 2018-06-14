package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.LoaiNguyenLieu;
import model.NguyenLieu;
import model.NhaCungCap;

public class NguyenLieuDAO implements INguyenLieu {

	private static ConnectionPool pool;

	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	@Override
	public List<NguyenLieu> getList() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		String sql = "select * from NGUYENLIEU";
		//
		List<NguyenLieu> listNguyenLieu = new ArrayList<NguyenLieu>();
		INhaCungCap iNhaCungCap = new NhaCungCapDAO();
		//
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//
		while (rs.next()) {
			String maNL = rs.getString("MA_NL");
			String tenNL = rs.getString("TEN_NL");
			int soLuong = rs.getInt("SO_LUONG");
			String maLNL = rs.getString("MA_LNL");
			String maNCC = rs.getString("MA_NCC");
			//
			listNguyenLieu.add(
					new NguyenLieu(maNL, tenNL, soLuong, getLoaiNguyenLieu(maLNL), iNhaCungCap.getNhaCungCap(maNCC)));
		}
		con.close();
		//
		return listNguyenLieu;
	}

	@Override
	public void updateNguyenLieu(String maNguyenLieu, NguyenLieu nguyenLieu)
			throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection conn = pool.getConnection();
		//
		String sql = "UPDATE NGUYENLIEU SET TEN_NL = N'" + nguyenLieu.getTen() + "', SO_LUONG = "
				+ nguyenLieu.getSoLuong() + ", MA_LNL = N'" + nguyenLieu.getLoai().getMa() + "', MA_NCC = N'"
				+ nguyenLieu.getNhaCungCap().getMaNCC() + "' WHERE MA_NL = '" + maNguyenLieu + "'";
		System.out.println("SQL:" + sql);
		//
		try {
			Statement stmt = null;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public NguyenLieu getLoaiHang(String maNguyenLieu) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void xoaNguyenLieu(String maNguyenLieu) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NguyenLieuDAO ql = new NguyenLieuDAO();
		List<NguyenLieu> list = ql.getList();
		for (NguyenLieu nl : list) {
			System.out.println(nl.getMaNL());
		}
		NguyenLieu nl = new NguyenLieu("05", "abkjsh", 10, new LoaiNguyenLieu("G01", "GO"),
				new NhaCungCap("NCC01", "ten", 817893279, "diaChi", "email"));

		ql.themNguyenLieu(nl);
	}

	@Override
	public void themNguyenLieu(NguyenLieu nguyenLieu) {
		try {
			pool = new ConnectionPool(url, user, password, driver, 10, 5);
			Connection conn = pool.getConnection();
			//
			String sql = "insert into NGUYENLIEU values ('" + nguyenLieu.getMaNL() + "','" + nguyenLieu.getTen() + "','"
					+ nguyenLieu.getSoLuong() + "','" + nguyenLieu.getLoai().getMa() + "','"
					+ nguyenLieu.getNhaCungCap().getMaNCC() + "');";
			System.out.println("SQL:" + sql);
			Statement stmt = null;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public LoaiNguyenLieu getLoaiNguyenLieu(String maLoaiNguyenLieu) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		String sql = "select * from LOAINGUYENLIEU where MA_LNL='" + maLoaiNguyenLieu + "';";
		List<NguyenLieu> listNguyenLieu = new ArrayList<NguyenLieu>();
		//
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//
		String tenLoaiNL = null;
		//
		while (rs.next()) {
			tenLoaiNL = rs.getString("TEN_LNL");
		}
		return new LoaiNguyenLieu(maLoaiNguyenLieu, tenLoaiNL);
	}

	@Override
	public List<LoaiNguyenLieu> getListLoaiNguyenLieu() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		String sql = "select * from LOAINGUYENLIEU;";
		List<NguyenLieu> listNguyenLieu = new ArrayList<NguyenLieu>();
		//
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//
		List<LoaiNguyenLieu> list = new ArrayList<LoaiNguyenLieu>();
		String tenLoaiNL = null, maLoaiNguyenLieu = null;
		//
		while (rs.next()) {
			maLoaiNguyenLieu = rs.getString("MA_LNL");
			tenLoaiNL = rs.getString("TEN_LNL");
			//
			list.add(new LoaiNguyenLieu(maLoaiNguyenLieu, tenLoaiNL));
		}
		return list;
	}

	@Override
	public NguyenLieu getNguyenLieu(String maNguyenLieu) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		String sql = "select * from NGUYENLIEU Where MA_NL = '" + maNguyenLieu + "'";
		//
		INhaCungCap iNhaCungCap = new NhaCungCapDAO();
		String tenNL = null, maLNL = null, maNCC = null;
		int soLuong = 0;
		//
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//
		while (rs.next()) {
			tenNL = rs.getString("TEN_NL");
			soLuong = rs.getInt("SO_LUONG");
			maLNL = rs.getString("MA_LNL");
			maNCC = rs.getString("MA_NCC");
		}
		con.close();
		//
		return new NguyenLieu(maNguyenLieu, tenNL, soLuong, getLoaiNguyenLieu(maLNL), iNhaCungCap.getNhaCungCap(maNCC));
	}
}
