package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements IKhachHang{

private static ConnectionPool pool;
	
	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	@Override
	public void themKhachHang(KhachHang kh) throws ClassNotFoundException, SQLException {
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
	public ArrayList<KhachHang> layDanhSachKhachHang() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		
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
	public void xoaKhachHang(String ma_kh) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
		
		KhachHang kh = new KhachHang("05", "Nguyá»…n VÄƒn Lan", true, "sá»‘ 16, Ä‘Æ°á»�ng HĂ  Thá»‹ Lan, quáº­n 12", 12348978);
		KhachHang kh1 = new KhachHang("06", "HĂ  Thá»‹ Linh", false, "sá»‘ 19, Ä‘Æ°á»�ng Nguyá»…n Thá»‹ Minh Khai, quáº­n 4", 22445566);
		KhachHang kh2 = new KhachHang("07", "Cao BĂ¡ QuĂ¡t", true, "sá»‘ 22, Ä‘Æ°á»�ng HĂ  Thá»‹ Lan, quáº­n 12", 16245231);
		KhachHang kh3 = new KhachHang("08", "LĂª VÄƒn Lá»£i", true, "sá»‘ 21, Ä‘Æ°á»�ng HĂ  Thá»‹ Lan, quáº­n 12", 12348978);
		KhachHang kh4 = new KhachHang("09", "Táº¡ VÄƒn Báº£n", true, "sá»‘ 26, Ä‘Æ°á»�ng Nguyá»…n VÄƒn A, quáº­n 1", 3243746);
		KhachHang kh5 = new KhachHang("10", "VĂµ Há»“ng Diá»‡u", true, "sá»‘ 15, Ä‘Æ°á»�ng Nguyá»…n VÄƒn B, quáº­n 2", 12323545);
		
		listKH.add(kh);
		listKH.add(kh1);
		listKH.add(kh2);
		listKH.add(kh3);
		listKH.add(kh4);
		listKH.add(kh5);
		
		KhachHangDAO khdao = new KhachHangDAO();
		
		for (KhachHang khang : listKH) {
			khdao.themKhachHang(khang);
		}
		
	}

}