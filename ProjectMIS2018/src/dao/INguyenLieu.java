package dao;

import java.sql.SQLException;
import java.util.List;
import model.NguyenLieu;

public interface INguyenLieu {
	// Lay danh sach nhung loai hang.
		public List<NguyenLieu> getList() throws ClassNotFoundException, SQLException;
		
		// Lay loai hang theo ma loai.
		public NguyenLieu getLoaiHang(String maNguyenLieu) throws ClassNotFoundException, SQLException;
		
		// Xoa loai hang do dua vao ma_loaihang.
		public void xoaNguyenLieu(String maNguyenLieu) throws ClassNotFoundException, SQLException;
		
		// Update loai hang.
		public void updateNguyenLieu(NguyenLieu nguyenLieu) throws ClassNotFoundException, SQLException;
}
