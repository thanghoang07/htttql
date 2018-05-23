package model;

import java.util.List;

public class ChiTietDonHang {
	private String maDonHang;
	private SanPham sanPham;
	private int soLuong;

	public ChiTietDonHang(String maDonHang, SanPham sanPham, int soLuong) {
		super();
		this.maDonHang = maDonHang;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public SanPham getsanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham listSanPham) {
		this.sanPham = listSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maDonHang=" + maDonHang + ", listSanPham=" + sanPham + ", soLuong=" + soLuong + "]";
	}

}
