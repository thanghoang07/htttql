package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoaiNhanSu;
import model.NhanSu;

public class NhanSuDAO implements INhanSu {
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

		ps.setString(1, ns.getMaNS());
		ps.setString(2, ns.getTenNS());
		ps.setString(3, ns.getLoai().getMa_loains());
		ps.setDate(4, ns.getNgaySinh());
		ps.setBoolean(5, ns.getGioiTinh());
		ps.setString(6, ns.getDiaChi());
		ps.setDate(7, ns.getNgayVaoLam());

		ps.executeUpdate();

		con.close();

	}

	@Override
	public ArrayList<NhanSu> layDanhSachNhanSuTheoLoaiNhanSu(String ma_loainhansu)
			throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "SELECT * FROM NHANSU ns inner join LOAINHANSU lns on lns.MA_LOAINS = ns.MA_LOAINS where MA_LOAINS='"
				+ ma_loainhansu + "'";

		ArrayList<NhanSu> listNhanSu = new ArrayList<NhanSu>();

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String ma_ns = rs.getString("MA_NS");
			String ten_ns = rs.getString("TEN_NS");
			String ma_loains = rs.getString("MA_LOAINS");
			Date ngaysinh = rs.getDate("NGAY_SINH");
			boolean gioiTinh = rs.getBoolean("GIOI_TINH");
			String diachi = rs.getString("DIA_CHI");
			Date ngayvaolam = rs.getDate("NGAY_VAO_LAM");
			String tenLoaiNS = rs.getString("TENLOAINS");
			float luong = rs.getFloat("LUONG");
			//
			listNhanSu.add(new NhanSu(ma_ns, ten_ns, ngaysinh, diachi, gioiTinh, ngayvaolam,
					new LoaiNhanSu(ma_loains, tenLoaiNS, luong)));
		}

		con.close();

		return listNhanSu;
	}

	@Override
	public List<NhanSu> layDanhSachNhanSu() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "SELECT * FROM NHANSU ns inner join LOAINHANSU lns on lns.MA_LOAINS = ns.MA_LOAINS;";

		ArrayList<NhanSu> listNhanSu = new ArrayList<NhanSu>();

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String ma_ns = rs.getString("MA_NS");
			String ten_ns = rs.getString("TEN_NS");
			String ma_loains = rs.getString("MA_LOAINS");
			Date ngaysinh = rs.getDate("NGAY_SINH");
			boolean gioiTinh = rs.getBoolean("GIOI_TINH");
			String diachi = rs.getString("DIA_CHI");
			Date ngayvaolam = rs.getDate("NGAY_VAO_LAM");
			String tenLoaiNS = rs.getString("TENLOAINS");
			float luong = rs.getFloat("LUONG");
			//
			listNhanSu.add(new NhanSu(ma_ns, ten_ns, ngaysinh, diachi, gioiTinh, ngayvaolam,
					new LoaiNhanSu(ma_loains, tenLoaiNS, luong)));
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
		NhanSuDAO nsd = new NhanSuDAO();
		List<NhanSu> list = nsd.layDanhSachNhanSu();
		for (NhanSu ns : list) {
			System.out.println(ns.toString());
		}
	}
}
