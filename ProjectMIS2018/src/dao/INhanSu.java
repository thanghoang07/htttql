package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NhanSu;

public interface INhanSu {

	// Them nhan su moi.
	public void addNhanSu(NhanSu ns) throws ClassNotFoundException, SQLException;

	// Hien thi danh sach nhan su theo loai nha su
	public ArrayList<NhanSu> layDanhSachNhanSuTheoLoaiNhanSu(String ma_loainhansu)
			throws ClassNotFoundException, SQLException;

	// Hien thi danh sach nhan su theo loai nha su
	public List<NhanSu> layDanhSachNhanSu() throws ClassNotFoundException, SQLException;

	public NhanSu getNhanSu(String ma_ns);

}