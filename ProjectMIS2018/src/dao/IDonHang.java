package dao;

import java.sql.SQLException;
import java.util.List;

import model.DonHang;

public interface IDonHang {
	// Them khach hang vao database.
	public void themDonHang(DonHang kh) throws ClassNotFoundException, SQLException;

	// Lay danh sach khach hang.
	public List<DonHang> layDanhSachDonHang() throws ClassNotFoundException, SQLException;

	// Xoa khach hang dua vao ma_kh.
	public void xoaDonHang(String ma_kh);

	// Update khach hang.
	public void updateDonHang(DonHang kh);
}
