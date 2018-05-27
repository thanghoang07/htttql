package model;

import java.util.List;

public class SanPham {

	private String maSP, ten;
	private int soLuong;
	private float gia;
	private String kichThuoc;
	private LoaiHang loaiHang;
	private String urlHinh;
	private List<NguyenLieu> danhSachNL;

	public SanPham(String maSP, String ten, int soLuong, float gia, String kichThuoc, LoaiHang loaiHang, String urlHinh) {
		super();
		this.maSP = maSP;
		this.ten = ten;
		this.soLuong = soLuong;
		this.gia = gia;
		this.kichThuoc = kichThuoc;
		this.loaiHang = loaiHang;
		this.urlHinh = urlHinh;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public LoaiHang getLoaiHang() {
		return loaiHang;
	}

	public void setLoaiHang(LoaiHang loaiHang) {
		this.loaiHang = loaiHang;
	}

	public String getUrlHinh() {
		return urlHinh;
	}

	public void setUrlHinh(String urlHinh) {
		this.urlHinh = urlHinh;
	}

	public List<NguyenLieu> getDanhSachNL() {
		return danhSachNL;
	}

	public void setDanhSachNL(List<NguyenLieu> danhSachNL) {
		this.danhSachNL = danhSachNL;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", ten=" + ten + ", soLuong=" + soLuong + ", gia=" + gia + ", kichThuoc="
				+ kichThuoc + ", loaiHang=" + loaiHang + ", urlHinh=" + urlHinh + ", danhSachNL=" + danhSachNL + "]";
	}

}
