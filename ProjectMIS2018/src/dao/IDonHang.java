package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import model.ChiTietDonHang;
import model.DonHang;
import model.LoaiHang;
import model.SanPham;
import model.TrangThaiDonHang;

public interface IDonHang {
	// Them khach hang vao database.
	public void themDonHang(DonHang dh) throws ClassNotFoundException, SQLException;

	// Them khach hang vao database.
	public void themChiTietDonHang(ChiTietDonHang ctdh) throws ClassNotFoundException, SQLException;

	// Lay danh sach khach hang.
	public List<DonHang> layDanhSachDonHang() throws ClassNotFoundException, SQLException;

	// Xoa khach hang dua vao ma_kh.
	public void xoaDonHang(String ma_kh);

	// Update khach hang.
	public void updateDonHang(DonHang kh);

	// Trang thai don hang
	public TrangThaiDonHang getTrangThai(String maTrangThai) throws ClassNotFoundException, SQLException;

	// danh sach sam pham theo chi tiet don hang
	public HashMap<SanPham, Integer> listSanPhamTheoCTDH(String maChiTietDonHang)
			throws ClassNotFoundException, SQLException;

	// lay loai hang theo ma
	public LoaiHang getLoaiHang(String maLoaiHang) throws ClassNotFoundException, SQLException;

	// lay loai hang theo ma
	public List<LoaiHang> getListLoaiHang() throws ClassNotFoundException, SQLException;

	// lay chi tiet don hang
	public ChiTietDonHang getChiTietDonHang(String maDonHang) throws ClassNotFoundException, SQLException;

	// lya don hang
	public DonHang getDonHang(String maDonHang) throws ClassNotFoundException, SQLException;

	// lya don hang
	public SanPham getSanPham(String maSanPham) throws ClassNotFoundException, SQLException;

	public List<SanPham> getListSanPham(String maLoaiHang) throws ClassNotFoundException, SQLException;

	//
	public List<SanPham> getListSanPham() throws ClassNotFoundException, SQLException;

	// lay maDonHang Trong ngay
	public String getMaDonHang() throws ClassNotFoundException, SQLException;

	// lay maSanPham Trong ngay
	public String getMaSanPham() throws ClassNotFoundException, SQLException;

	// them san pham
	public void themSanPham(SanPham sanPham);

}
