package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;
import model.LoaiHang;
import model.LoaiNhanSu;
import model.NhanSu;
import model.SanPham;
import model.TrangThaiDonHang;

public class DonHangDAO implements IDonHang {

	private static ConnectionPool pool;

	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	@Override
	public void themDonHang(DonHang dh) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		String sql = " insert into DONHANG values (?,?,?,?,?,?,?);";
		//
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		//
		ps.setString(1, dh.getMaDH());
		ps.setString(2, dh.getNhanVienKD().getMaNS());
		ps.setString(3, dh.getKhachHang().getMa_kh());
		ps.setFloat(4, dh.getTongTien());
		ps.setDate(5, dh.getNgayNhan());
		ps.setDate(6, dh.getNgayGiao());
		ps.setString(7, dh.getTrangThai().getMaTrangThai());
		//
		ps.executeUpdate();
		//
		con.close();
	}

	@Override
	public List<DonHang> layDanhSachDonHang() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		IKhachHang ikhachHang = new KhachHangDAO();
		List<DonHang> listDonHang = new ArrayList<DonHang>();
		INhanSu iNhanSu = new NhanSuDAO();
		//
		String sql = "select * from DonHang;";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String maDonHang = rs.getString("MA_DH");
			String maNhanSu = rs.getString("MA_NS");
			String maKhachHang = rs.getString("MA_KH");
			float tongTien = rs.getFloat("TONG_TIEN");
			Date ngayNhan = rs.getDate("NGAY_NHAN");
			Date ngayGiao = rs.getDate("NGAY_GIAO");
			String maTTDH = rs.getString("MA_TTDH");
			//
			listDonHang.add(new DonHang(maDonHang, iNhanSu.getNhanSu(maNhanSu), ngayNhan, ngayGiao, tongTien,
					getChiTietDonHang(maDonHang), ikhachHang.getKhachHang(maKhachHang), getTrangThai(maTTDH)));
		}

		con.close();

		return listDonHang;
	}

	@Override
	public void xoaDonHang(String ma_kh) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDonHang(DonHang kh) {
		// TODO Auto-generated method stub

	}

	@Override
	public TrangThaiDonHang getTrangThai(String maTrangThai) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from TRANGTHAIDH where  MA_TTDH = '" + maTrangThai + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		String ten = null;

		while (rs.next()) {
			ten = rs.getString("TEN_TTDH");
		}

		con.close();

		return new TrangThaiDonHang(maTrangThai, ten);
	}

	@Override
	public List<SanPham> listSanPhamTheoCTDH(String maDonHang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from CHITIETDONHANG ctdh inner join SANPHAM sp on ctdh.MA_SP = sp.MA_SP where ctdh.MA_DH = '"
				+ maDonHang + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<SanPham> listSP = new ArrayList<SanPham>();

		while (rs.next()) {
			String maSP = rs.getString("MA_SP");
			String tenSP = rs.getString("TEN_SP");
			int soLuongSP = rs.getInt("SO_LUONG");
			float gia = rs.getFloat("GIA");
			String kichThuoc = rs.getString("KICH_THUOC");
			String urlHinh = rs.getString("URL_HINH");
			String maLoaiHang = rs.getString("MA_LH");
			//
			listSP.add(new SanPham(maSP, tenSP, soLuongSP, gia, kichThuoc, getLoaiHang(maLoaiHang), urlHinh));
		}

		return listSP;
	}

	@Override
	public LoaiHang getLoaiHang(String maLoaiHang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from LOAIHANG where MA_LH='" + maLoaiHang + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		String ten = null;

		while (rs.next()) {
			ten = rs.getString("TEN_LH");
		}

		con.close();

		return new LoaiHang(maLoaiHang, ten);
	}

	@Override
	public ChiTietDonHang getChiTietDonHang(String maDonHang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from CHITIETDONHANG where MA_DH = '" + maDonHang + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		String maSanPham = null;
		int soLuongSP = 0;

		while (rs.next()) {
			maSanPham = rs.getString("MA_SP");
			soLuongSP = rs.getInt("SO_LUONG");
		}

		con.close();

		return new ChiTietDonHang(maDonHang, listSanPhamTheoCTDH(maDonHang), soLuongSP);
	}

	@Override
	public DonHang getDonHang(String maDonHang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		IKhachHang ikhachHang = new KhachHangDAO();
		INhanSu iNhanSu = new NhanSuDAO();
		//
		String sql = "select * from DONHANG where MA_DH = '" + maDonHang + "';";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//
		String maNhanSu = null, maKhachHang = null, maTrangThai = null;
		float tongTien = 0;
		Date ngayNhan = null, ngayGiao = null;
		//
		while (rs.next()) {
			maNhanSu = rs.getString("MA_NS");
			maKhachHang = rs.getString("MA_KH");
			tongTien = rs.getFloat("TONG_TIEN");
			ngayNhan = rs.getDate("NGAY_NHAN");
			ngayGiao = rs.getDate("NGAY_GIAO");
			maTrangThai = rs.getString("MA_TTDH");
		}

		con.close();

		return new DonHang(maDonHang, iNhanSu.getNhanSu(maNhanSu), ngayNhan, ngayGiao, tongTien,
				getChiTietDonHang(maDonHang), ikhachHang.getKhachHang(maKhachHang), getTrangThai(maTrangThai));
	}

	@Override
	public SanPham getSanPham(String maSanPham) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from SANPHAM Where MA_SP='" + maSanPham + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		//
		String maSP = null, tenSP = null;
		int soLuongSP = 0;
		float gia = 0;
		String kichThuoc = null, urlHinh = null, maLoaiHang = null;

		while (rs.next()) {
			maSP = rs.getString("MA_SP");
			tenSP = rs.getString("TEN_SP");
			soLuongSP = rs.getInt("SO_LUONG");
			gia = rs.getFloat("GIA");
			kichThuoc = rs.getString("KICH_THUOC");
			urlHinh = rs.getString("URL_HINH");
			maLoaiHang = rs.getString("MA_LH");
		}

		return new SanPham(maSP, tenSP, soLuongSP, gia, kichThuoc, getLoaiHang(maLoaiHang), urlHinh);
	}

	@Override
	public String getMaDonHang() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select MA_DH from DONHANG;";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		//
		String maSP = null;
		while (rs.next()) {
			maSP = rs.getString("MA_DH");
		}
		return maSP;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DonHangDAO dhd = new DonHangDAO();
		List<DonHang> list = dhd.layDanhSachDonHang();
		for (DonHang dh : list) {
			System.out.println(dh.toString());
		}
	}
}
