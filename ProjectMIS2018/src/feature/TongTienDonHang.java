package feature;

import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

import dao.ThongKe;
import model.SanPham;

public class TongTienDonHang {

	public float tongTien(HashMap<SanPham, Integer> ctdh) {
		float gia = 0;
		for (Entry<SanPham, Integer> entry : ctdh.entrySet()) {
			gia += entry.getKey().getGia() * entry.getValue();
		}
		return gia;
	}

	public float tongTienTongDonHangTheoKhachHang(String maKhachHang) throws ClassNotFoundException, SQLException {
		float tong = 0;
		ThongKe tk = new ThongKe();
		for (Float fTien : tk.danhSachTienDonHangMotKhachHang(maKhachHang)) {
			tong += fTien.floatValue();
		}
		return tong;
	}
	
	public float tongTienTongDoanhThuTheoTongKhachHang() throws ClassNotFoundException, SQLException {
		float tong = 0;
		ThongKe tk = new ThongKe();
		for (Float fTien : tk.danhSachDoanhThuTongKhachHang()) {
			tong += fTien.floatValue();
		}
		return tong;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TongTienDonHang tt = new TongTienDonHang();
		Locale locale = new Locale("en", "EN");
		System.out.println(NumberFormat.getInstance(locale).format(tt.tongTienTongDoanhThuTheoTongKhachHang()));
	}

}
