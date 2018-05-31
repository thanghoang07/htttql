package feature;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;

import dao.DonHangDAO;
import dao.IDonHang;
import model.SanPham;

public class TongTienDonHang {

	public float tongTien(HashMap<SanPham, Integer> ctdh) {
		float gia = 0;
		for (Entry<SanPham, Integer> entry : ctdh.entrySet()) {
			gia += entry.getKey().getGia() * entry.getValue();
		}
		return gia;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String nag = "2018-05-30";
		Date da= Date.valueOf(nag);
		System.out.println(da);
	}

}
