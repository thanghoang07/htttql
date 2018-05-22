package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.LoaiHang;

public interface IQuanLyLoaiHang {
	
	// Lay danh sach nhung loai hang.
	public ArrayList<LoaiHang> getList() throws ClassNotFoundException, SQLException;
	
	// Lay loai hang theo ma loai.
	public LoaiHang getLoaiHang(String ma_loaihang) throws ClassNotFoundException, SQLException;
	
	// Xoa loai hang do dua vao ma_loaihang.
	public void xoaLoaiHang(String ma_loaihang) throws ClassNotFoundException, SQLException;
	
	// Update loai hang.
	public void updateLoaiHang(LoaiHang loaiHang) throws ClassNotFoundException, SQLException;

}
