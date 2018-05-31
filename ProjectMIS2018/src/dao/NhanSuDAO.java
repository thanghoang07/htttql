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
import model.TrangThaiDonHang;

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
	public List<NhanSu> getListNhanSuTheoLoaiNhanSu(String ma_loainhansu)
			throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from NHANSU where MA_LOAINS = '" + ma_loainhansu + "';";
		//
		ArrayList<NhanSu> listNhanSu = new ArrayList<NhanSu>();
		//
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
			//
			listNhanSu.add(new NhanSu(ma_ns, ten_ns, ngaysinh, diachi, gioiTinh, ngayvaolam, getLoaiNhanSu(ma_loains)));
		}
		con.close();
		return listNhanSu;
	}

	@Override
	public List<NhanSu> getListNhanSu() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "SELECT * FROM NHANSU;";

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
			//
			listNhanSu.add(new NhanSu(ma_ns, ten_ns, ngaysinh, diachi, gioiTinh, ngayvaolam, getLoaiNhanSu(ma_loains)));
		}

		con.close();

		return listNhanSu;
	}

	@Override
	public NhanSu getNhanSu(String maNhanSu) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from NHANSU where MA_NS='" + maNhanSu + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		String maNS = null, tenNS = null, diaChi = null, maLoaiNS = null;
		boolean gioiTinh = false;
		Date ngaySinh = null, ngayVaoLam = null;

		while (rs.next()) {
			maNS = rs.getString("MA_NS");
			tenNS = rs.getString("TEN_NS");
			maLoaiNS = rs.getString("MA_LOAINS");
			ngaySinh = rs.getDate("NGAY_SINH");
			ngayVaoLam = rs.getDate("NGAY_VAO_LAM");
			gioiTinh = rs.getBoolean("GIOI_TINH");
			diaChi = rs.getString("DIA_CHI");
		}

		con.close();

		return new NhanSu(maNS, tenNS, ngaySinh, diaChi, gioiTinh, ngayVaoLam, getLoaiNhanSu(maLoaiNS));
	}

	@Override
	public LoaiNhanSu getLoaiNhanSu(String maLoaiNS) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = " select * from LOAINHANSU where MA_LOAINS='" + maLoaiNS + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		String ten = null;
		float luong = 0;

		while (rs.next()) {
			ten = rs.getString("TENLOAINS");
			luong = rs.getFloat("LUONG");
		}

		con.close();

		return new LoaiNhanSu(maLoaiNS, ten, luong);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NhanSuDAO nsd = new NhanSuDAO();
		List<NhanSu> list = nsd.getListNhanSu();
		for (NhanSu ns : list) {
			System.out.println(ns.toString());
		}
	}
}
