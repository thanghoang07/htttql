package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoaiNhanSu;

public class QuanLyNhanSuDAO implements IQuanLyNhanSu {
private static ConnectionPool pool;
	
	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";


	@Override
	public void themLoaiNhanSu(LoaiNhanSu loai_ns) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
			
		
			String sql = "insert into LOAINHANSU value(?,?,?);";
		
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, loai_ns.getMa_loains());
			ps.setString(2, loai_ns.getTen_loains());
			ps.setDouble(3, loai_ns.getLuong());
			
			ps.executeUpdate();
			
			con.close();
		
	}

	@Override
	public ArrayList<LoaiNhanSu> getList() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		ArrayList<LoaiNhanSu> list = new ArrayList<LoaiNhanSu>();
		
		String sql = "SELECT * FROM LOAINHANSU;";
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			String maloains = rs.getString("MA_LOAINS");
			
			String tenloains = rs.getString("TENLOAINS");
			
			double luong = rs.getDouble("LUONG");
			
			list.add(new LoaiNhanSu(maloains, tenloains, luong));
			
		}
		
		con.close();
		
		return list;
	}

	@Override
	public LoaiNhanSu getLoaiNhanSu(String ma_loains) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		String sql = "SELECT * FROM LOAINHANSU WHERE MA_LOAINS='" + ma_loains + "';";
		
		LoaiNhanSu lns = new LoaiNhanSu();
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			String ma_loains1 = rs.getString("MA_LOAINS");
			String ten_loains1 = rs.getString("TENLOAINS");
			double luong1 = rs.getDouble("LUONG");
			lns = new LoaiNhanSu(ma_loains1, ten_loains1, luong1);
		}
		
		con.close();
		
		return lns;
	}

	@Override
	public void xoaLoaiNhanSu(String ma_loains) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		String sql = "DELETE FROM LOAINHANSU WHERE MA_LOAINS = '" + ma_loains + "';";
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ps.executeQuery();
		
		con.close();
		
	}

	@Override
	public void updateLoaiNhanSu(LoaiNhanSu loai_ns) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		String sql = "UPDATE LOAINHANSU SET TENLOAINS=?, LUONG=? WHERE MA_LOAINS=?";
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ps.setString(1, loai_ns.getTen_loains());
		ps.setDouble(2, loai_ns.getLuong());
		ps.setString(3, loai_ns.getMa_loains());
		
		ps.executeUpdate();
		
		con.close();
		
	}	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ArrayList<LoaiNhanSu> listLOAINS = new QuanLyNhanSuDAO().getList();
		
		for (LoaiNhanSu lns : listLOAINS) {
			System.out.print("MA LOAI NHAN SU: " + lns.getMa_loains());
			System.out.println(" TEN NHAN SU: " + lns.getTen_loains());
			System.out.println(" LUONG: " + lns.getLuong());
		}
		
		System.out.println(new QuanLyNhanSuDAO().getLoaiNhanSu("KD").toString());
		
		System.out.println();
		
	}
	
	
}
