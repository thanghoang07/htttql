package dao;

import java.sql.SQLException;
import java.util.List;

import model.KhachHang;

public interface IKhachHang {
	// Them khach hang vao database.
	public void addKhachHang(KhachHang kh) throws ClassNotFoundException, SQLException;

	// Lay danh sach khach hang.
	public List<KhachHang> getListKhachHang() throws ClassNotFoundException, SQLException;

	// Xoa khach hang dua vao ma_kh.
	public void hidenKhachHang(String ma_kh);

	// Update khach hang.
	public void updateKhachHang(KhachHang kh);

	//
	public KhachHang getKhachHang(String maKhachHang) throws ClassNotFoundException, SQLException;

	//
	public String getMaKhachHang() throws ClassNotFoundException, SQLException;
}
