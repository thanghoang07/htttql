package model;

import java.util.HashMap;

public class ChiTietDonHang {
	private String maDonHang;
	private HashMap<SanPham, Integer> sanPhamSoLuong;

	public ChiTietDonHang(String maDonHang, HashMap<SanPham, Integer> sanPhamSoLuong) {
		super();
		this.maDonHang = maDonHang;
		this.sanPhamSoLuong = sanPhamSoLuong;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public HashMap<SanPham, Integer> getSanPhamSoLuong() {
		return sanPhamSoLuong;
	}

	public void setSanPhamSoLuong(HashMap<SanPham, Integer> sanPhamSoLuong) {
		this.sanPhamSoLuong = sanPhamSoLuong;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maDonHang=" + maDonHang + ", sanPhamSoLuong=" + sanPhamSoLuong + "]";
	}

}
