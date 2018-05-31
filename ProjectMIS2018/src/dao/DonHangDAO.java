package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
	public void themDonHang(DonHang donhang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		String sql = " insert into DONHANG values (?,?,?,?,?,?,?);";
		//
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		//
		ps.setString(1, donhang.getMaDH());
		ps.setString(2, donhang.getNhanVienKD().getMaNS());
		ps.setString(3, donhang.getKhachHang().getMa_kh());
		ps.setFloat(4, donhang.getTongTien());
		ps.setDate(5, donhang.getNgayNhan());
		ps.setDate(6, donhang.getNgayGiao());
		ps.setString(7, donhang.getTrangThai().getMaTrangThai());
		//
		ps.executeUpdate();
		//
		themChiTietDonHang(donhang.getChiTietDonHang());
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
		String sql = "select * from DONHANG;";

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
	public HashMap<SanPham, Integer> listSanPhamTheoCTDH(String maDonHang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from CHITIETDONHANG ctdh inner join SANPHAM sp on ctdh.MA_SP = sp.MA_SP where ctdh.MA_DH = '"
				+ maDonHang + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		HashMap<SanPham, Integer> listSP = new HashMap<SanPham, Integer>();

		while (rs.next()) {
			String maSP = rs.getString("MA_SP");
			int soLuongSP = rs.getInt("SO_LUONG");
			//
			listSP.put(getSanPham(maSP), soLuongSP);
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
		}

		con.close();

		return new ChiTietDonHang(maDonHang, listSanPhamTheoCTDH(maDonHang));
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

	@Override
	public List<SanPham> getListSanPham(String maLoaiHang) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from SANPHAM Where MA_LH='" + maLoaiHang + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		//
		List<SanPham> list = new ArrayList<SanPham>();
		String maSP = null, tenSP = null;
		int soLuongSP = 0;
		float gia = 0;
		String kichThuoc = null, urlHinh = null;
		//
		while (rs.next()) {
			maSP = rs.getString("MA_SP");
			tenSP = rs.getString("TEN_SP");
			soLuongSP = rs.getInt("SO_LUONG");
			gia = rs.getFloat("GIA");
			kichThuoc = rs.getString("KICH_THUOC");
			urlHinh = rs.getString("URL_HINH");
			//
			list.add(new SanPham(maSP, tenSP, soLuongSP, gia, kichThuoc, getLoaiHang(maLoaiHang), urlHinh));
		}

		return list;
	}

	@Override
	public String getMaSanPham() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select MA_SP from SANPHAM;";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		//
		String maSP = null;
		while (rs.next()) {
			maSP = rs.getString("MA_SP");
		}
		return maSP;
	}

	@Override
	public List<LoaiHang> getListLoaiHang() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		String sql = "select * from LOAIHANG;";
		//
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//
		List<LoaiHang> list = new ArrayList<LoaiHang>();
		String ten = null, maLoaiHang = null;
		//
		while (rs.next()) {
			maLoaiHang = rs.getString("MA_LH");
			ten = rs.getString("TEN_LH");
			list.add(new LoaiHang(maLoaiHang, ten));
		}
		con.close();
		return list;
	}

	@Override
	public void themSanPham(SanPham sanPham) {
		try {
			pool = new ConnectionPool(url, user, password, driver, 10, 5);
			Connection conn = pool.getConnection();
			//
			String sql = "insert into SANPHAM values ('" + sanPham.getMaSP() + "','" + sanPham.getTen() + "',"
					+ sanPham.getSoLuong() + "," + sanPham.getGia() + ",'" + sanPham.getKichThuoc() + "','"
					+ sanPham.getLoaiHang().getMa_loaihang() + "','" + sanPham.getUrlHinh() + "');";
			System.out.println("SQL:" + sql);
			Statement stmt = null;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SanPham> getListSanPham() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();
		//
		String sql = "select * from SANPHAM;";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//
		List<SanPham> list = new ArrayList<SanPham>();
		String maSP = null, tenSP = null, maLoaiHang = null, kichThuoc = null, urlHinh = null;
		int soLuongSP = 0;
		float gia = 0;
		//
		while (rs.next()) {
			maLoaiHang = rs.getString("MA_LH");
			maSP = rs.getString("MA_SP");
			tenSP = rs.getString("TEN_SP");
			soLuongSP = rs.getInt("SO_LUONG");
			gia = rs.getFloat("GIA");
			kichThuoc = rs.getString("KICH_THUOC");
			urlHinh = rs.getString("URL_HINH");
			//
			list.add(new SanPham(maSP, tenSP, soLuongSP, gia, kichThuoc, getLoaiHang(maLoaiHang), urlHinh));
		}
		return list;
	}

	@Override
	public void themChiTietDonHang(ChiTietDonHang ctdh) throws ClassNotFoundException, SQLException {
		try {
			pool = new ConnectionPool(url, user, password, driver, 10, 5);
			Connection conn = pool.getConnection();
			//
			HashMap<SanPham, Integer> spSL = ctdh.getSanPhamSoLuong();
			//
			for (Entry<SanPham, Integer> entry : spSL.entrySet()) {
				String sql = "insert into CHITIETDONHANG values ('" + ctdh.getMaDonHang() + "','"
						+ entry.getKey().getMaSP() + "'," + entry.getValue() + ");";
				System.out.println("SQL:" + sql);
				//
				Statement stmt = null;
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
