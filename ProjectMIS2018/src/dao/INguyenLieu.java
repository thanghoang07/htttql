package dao;

import java.sql.SQLException;
import java.util.List;

import model.LoaiNguyenLieu;
import model.NguyenLieu;

public interface INguyenLieu {
	// Lay danh sach nhung loai hang.
	public List<NguyenLieu> getList() throws ClassNotFoundException, SQLException;

	// Lay loai hang theo ma loai.
	public NguyenLieu getLoaiHang(String maNguyenLieu) throws ClassNotFoundException, SQLException;

	// Lay loai hang theo ma loai.
	public LoaiNguyenLieu getLoaiNguyenLieu(String maLoaiNguyenLieu) throws ClassNotFoundException, SQLException;

	// Lay loai hang theo ma loai.
	public List<LoaiNguyenLieu> getListLoaiNguyenLieu() throws ClassNotFoundException, SQLException;

	// Xoa loai hang do dua vao ma_loaihang.
	public void xoaNguyenLieu(String maNguyenLieu) throws ClassNotFoundException, SQLException;

	// Update loai hang.
	public void updateNguyenLieu(NguyenLieu nguyenLieu) throws ClassNotFoundException, SQLException;

	public void themNguyenLieu(NguyenLieu nguyenLieu);
}
