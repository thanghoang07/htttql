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
	public void themDonHang(DonHang kh) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DonHang> layDanhSachDonHang() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		List<DonHang> listDonHang = new ArrayList<DonHang>();

		String sql = "select * from DonHang dh inner join NHANSU ns on dh.MA_NS = ns.MA_NS"
				+ " inner join LOAINHANSU lns on lns.MA_LOAINS = ns.MA_LOAINS"
				+ " inner join KHACHHANG kh on kh.MA_KH = dh.MA_KH"
				+ " inner join TRANGTHAIDH ttd on ttd.MA_TTDH = dh.MA_TTDH"
				+ " inner join CHITIETDONHANG cdh on cdh.MA_DH=dh.MA_DH"
				+ " inner join SANPHAM sp on sp.MA_SP = cdh.MA_SP;";

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
			String tenNS = rs.getString("TEN_NS");
			String maLNS = rs.getString("MA_LOAINS");
			Date ngaySinh = rs.getDate("NGAY_SINH");
			boolean gioiTinhNS = rs.getBoolean("GIOI_TINH");
			String diaChi = rs.getString("DIA_CHI");
			Date ngayVaoLam = rs.getDate("NGAY_VAO_LAM");
			//
			String tenKhachHang = rs.getString("TEN_KH");
			boolean gioiTinhKH = rs.getBoolean("GIOI_TINH");
			String diachi = rs.getString("DIA_CHI");
			int sdt = rs.getInt("SDT");
			//
			String tenTTDH = rs.getString("TEN_TTDH");
			//
			String ten_loains = rs.getString("TENLOAINS");
			float luong = rs.getFloat("LUONG");
			//
			String maSP = rs.getString("MA_SP");
			int soLuong = rs.getInt("SO_LUONG");
			//
			String tenSP = rs.getString("TEN_SP");
			int soluongSP = rs.getInt("SO_LUONG");
			float giaSP = rs.getFloat("GIA");
			String kichThuocSP = rs.getString("KICH_THUOC");
			String maLH = rs.getString("MA_LH");
			String urlHinh = rs.getString("URL_HINH");
			//
			listDonHang.add(new DonHang(maDonHang,
					new NhanSu(maNhanSu, tenNS, ngaySinh, diachi, gioiTinhNS, ngayVaoLam,
							new LoaiNhanSu(maLNS, ten_loains, luong)),
					ngayNhan, ngayGiao, tongTien,
					new ChiTietDonHang(maDonHang,
							new SanPham(maSP, tenSP, soluongSP, giaSP, kichThuocSP, maLH, urlHinh), soLuong),
					new KhachHang(maKhachHang, tenKhachHang, gioiTinhKH, diachi, sdt),
					new TrangThaiDonHang(maTTDH, tenTTDH)));
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

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DonHangDAO dhd = new DonHangDAO();
		List<DonHang> list = dhd.layDanhSachDonHang();
		for (DonHang dh : list) {
			System.out.println(dh.getMaDH());
		}
	}
}
