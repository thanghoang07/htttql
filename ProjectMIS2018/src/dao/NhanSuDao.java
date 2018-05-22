package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NhanSu;

public class NhanSuDao implements INhanSu {
	private static ConnectionPool pool;

	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	@Override
	public void addNhanSu(NhanSu ns) throws ClassNotFoundException, SQLException {
		
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		String sql = "INSERT INTO NHANSU VALUE (?,?,?,?,?,?,?);";
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ps.setString(1, ns.getMa_ns());
		ps.setString(2, ns.getTen_ns());
		ps.setString(3, ns.getMa_loains());
		ps.setDate(4, ns.getNgaysinh());
		ps.setBoolean(5, ns.isGioitinh());
		ps.setString(6, ns.getDiachi());
		ps.setDate(7, ns.getNgayvaolam());
		
		ps.executeUpdate();
		
		con.close();
		
	}

	@Override
	public ArrayList<NhanSu> layDanhSachNhanSuTheoLoaiNhanSu(String ma_loainhansu) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		String sql = "SELECT * FROM NHANSU where MA_LOAINS='" + ma_loainhansu + "'";
		
		ArrayList<NhanSu> listNhanSu = new ArrayList<NhanSu>();
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			String ma_ns = rs.getString("MA_NS");
			String ten_ns = rs.getString("TEN_NS");
			String ma_loains = rs.getString("MA_LOAINS");
			Date ngaysinh = rs.getDate("NGAY_SINH");
			boolean gioitinh = rs.getBoolean("GIOI_TINH");
			String diachi = rs.getString("DIA_CHI");
			Date ngayvaolam = rs.getDate("NGAY_VAO_LAM");
			listNhanSu.add(new NhanSu(ma_ns, ten_ns, ma_loains, ngaysinh, gioitinh, diachi, ngayvaolam));
		}
		
		con.close();
		
		return listNhanSu;
	}

	

	@Override
	public List<NhanSu> layDanhSachNhanSu() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		String sql = "SELECT * FROM NHANSU";
		
		ArrayList<NhanSu> listNhanSu = new ArrayList<NhanSu>();
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			String ma_ns = rs.getString("MA_NS");
			String ten_ns = rs.getString("TEN_NS");
			String ma_loains = rs.getString("MA_LOAINS");
			Date ngaysinh = rs.getDate("NGAY_SINH");
			boolean gioitinh = rs.getBoolean("GIOI_TINH");
			String diachi = rs.getString("DIA_CHI");
			Date ngayvaolam = rs.getDate("NGAY_VAO_LAM");
			listNhanSu.add(new NhanSu(ma_ns, ten_ns, ma_loains, ngaysinh, gioitinh, diachi, ngayvaolam));
		}
		
		con.close();
		
		return listNhanSu;
	}

	@Override
	public NhanSu getNhanSu(String ma_ns) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NhanSuDao nsd = new NhanSuDao();
		List<NhanSu> list = nsd.layDanhSachNhanSu();
		for (NhanSu ns : list) {
			System.out.println(ns.toString());
		}
	}
}