package test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.DonHangDAO;
import dao.IDonHang;

public class Miami {
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

		return "" + (subNumber < 10) != null ? (ma + "0" + subNumber) : ma + subNumber;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Miami t = new Miami();
		System.out.println(t.autoMaDonHang());
	}
}
