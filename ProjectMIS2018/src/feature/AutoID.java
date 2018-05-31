package feature;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.DonHangDAO;
import dao.IDonHang;
import dao.IKhachHang;
import dao.KhachHangDAO;
import model.DonHang;

public class AutoID {
	// DH-YYYYMMDD-AA
	public String autoMaDonHang() throws ClassNotFoundException, SQLException {
		IDonHang iDonHang = new DonHangDAO();
		String maDonHang = iDonHang.getMaDonHang();
		//
		int subNgay = Integer.parseInt(maDonHang.substring(3, 11));
		int subNumber = Integer.parseInt(maDonHang.substring(12, maDonHang.length()));
		//
		Date day = new Date();
		//
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
		//
		String ma = "DH-" + ft.format(day) + "-";
		// kiem tra database -- lay 2 so cuoi -- tang len 1
		if (subNgay == Integer.parseInt(ft.format(day))) {
			subNumber = subNumber + 1;
		} else {
			subNumber = 1;
		}
		if (subNumber <= 9) {
			ma = ma + "0" + subNumber;
		} else {
			ma = ma + subNumber;
		}
		return ma;
	}

	// SPXYYYYMMDDAA
	public String autoMaSanPham(String maLoaiHang) throws ClassNotFoundException, SQLException {
		IDonHang iDonHang = new DonHangDAO();
		String maSanPham = iDonHang.getMaSanPham();
		//
		Date day = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
		String maLH = maLoaiHang.substring(0, 1);
		//

		int subNgay = Integer.parseInt(maSanPham.substring(3, 11));
		int subNumber = Integer.parseInt(maSanPham.substring(11, maSanPham.length()));
		//
		String ma = "SP" + maLH + "" + ft.format(day);
		// kiem tra database -- lay 2 so cuoi -- tang len 1
		if (subNgay == Integer.parseInt(ft.format(day))) {
			subNumber = subNumber + 1;
		} else {
			subNumber = 1;
		}
		if (subNumber <= 9) {
			ma = ma + "0" + subNumber;
		} else {
			ma = ma + subNumber;
		}
		return ma;
	}

	// KHYYMMDDAA
	public String autoMaKhachHang() throws ClassNotFoundException, SQLException {
		IKhachHang iKhachHang = new KhachHangDAO();
		String maKhachHang = iKhachHang.getMaKhachHang();
		//
		Date day = new Date();
		//
		SimpleDateFormat ft = new SimpleDateFormat("yyMMdd");
		//
		if (maKhachHang.length() <= 9) {
			return "KH" + ft.format(day) + "01";
		}
		//
		int subNgay = Integer.parseInt(maKhachHang.substring(2, 8));
		int subNumber = Integer.parseInt(maKhachHang.substring(9, maKhachHang.length()));
		String ma = "KH" + ft.format(day);
		// kiem tra database -- lay 2 so cuoi -- tang len 1
		if (subNgay == Integer.parseInt(ft.format(day))) {
			subNumber = subNumber + 1;
		} else {
			subNumber = 1;
		}
		if (subNumber <= 9) {
			ma = ma + "0" + subNumber;
		} else {
			ma = ma + subNumber;
		}
		return ma;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AutoID t = new AutoID();
		// System.out.println(t.autoMaDonHang());
		// System.out.println(t.autoMaSanPham("BAN"));
		// System.out.println(Boolean.valueOf("true") + " | " +
		// Boolean.valueOf("false"));
		System.out.println(t.autoMaKhachHang());
	}
}
