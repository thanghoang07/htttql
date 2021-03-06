package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoaiNhanSu;

public interface IQuanLyNhanSu {
	
	public void themLoaiNhanSu(LoaiNhanSu loai_ns) throws ClassNotFoundException, SQLException;
	
	// Lay danh sach nhung nhan su theo maloainhansu.
	public ArrayList<LoaiNhanSu> getList() throws ClassNotFoundException, SQLException;
	
	// Lay loai nhan su theo maloai
	public LoaiNhanSu getLoaiNhanSu(String ma_loains) throws ClassNotFoundException, SQLException;
	
	// Xoa loai nhan su dua vao ma_loains.
	public void xoaLoaiNhanSu(String ma_loains) throws ClassNotFoundException, SQLException;
	
	public void updateLoaiNhanSu(LoaiNhanSu loai_ns) throws ClassNotFoundException, SQLException;

}
