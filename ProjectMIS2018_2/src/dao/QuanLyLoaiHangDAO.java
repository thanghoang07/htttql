package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.LoaiHang;

public class QuanLyLoaiHangDAO implements IQuanLyLoaiHang {
private static ConnectionPool pool;
	
	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	@Override
	public ArrayList<LoaiHang> getList() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		ArrayList<LoaiHang> list = new ArrayList<LoaiHang>();
		
		String sql = "SELECT * FROM LOAIHANG;";
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			String ma_loaihang = rs.getString("MA_LH");
			String ten_loaihang = rs.getString("TEN_LH");
			
			list.add(new LoaiHang(ma_loaihang, ten_loaihang));
		}
		
		con.close();
		
		return list;
		
	}

	@Override
	public LoaiHang getLoaiHang(String ma_loaihang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		String sql = "SELECT * FROM LOAIHANG WHERE MA_LH='" + ma_loaihang + "';";
		
		LoaiHang lh = new LoaiHang();
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			String ma_loaihang1 = rs.getString("MA_LH");
			String ten_loaihang1 = rs.getString("TEN_LH");
			lh = new LoaiHang(ma_loaihang1, ten_loaihang1);
		}
		
		con.close();
		
		return lh;
	}

	@Override
	public void xoaLoaiHang(String ma_loaihang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		String sql = "DELETE FROM LOAIHANG WHERE MA_LH = '" + ma_loaihang + "';";
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ps.executeQuery();
		
		con.close();
	}

	@Override
	public void updateLoaiHang(LoaiHang loaiHang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		String sql = "UPDATE LOAINHANSU SET TEN_LH=? WHERE MA_LH=?";
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ps.setString(1, loaiHang.getTen_loaihang());
		ps.setString(2, loaiHang.getMa_loaihang());
		
		ps.executeUpdate();
		
		con.close();
		
	}
	
	
	
	

}
