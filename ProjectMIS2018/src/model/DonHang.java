package model;

import java.sql.Date;

public class DonHang {
	private String maDH;
	private NhanSu NhanVienKD;
	private Date ngayNhan;
	private Date ngayGiao;
	private float tongTien;
	private ChiTietDonHang chiTietDonHang;
	private KhachHang khachHang;
	private TrangThaiDonHang trangThai;

	public DonHang(String maDH, NhanSu NhanVienKD, Date ngayNhan, Date ngayGiao, float tongTien,
			ChiTietDonHang chiTietDonHang, KhachHang khachHang, TrangThaiDonHang trangThai) {
		super();
		this.maDH = maDH;
		this.NhanVienKD = NhanVienKD;
		this.ngayNhan = ngayNhan;
		this.ngayGiao = ngayGiao;
		this.tongTien = tongTien;
		this.chiTietDonHang = chiTietDonHang;
		this.khachHang = khachHang;
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "DonHang [maDH=" + maDH + ", NhanVienKD=" + NhanVienKD + ", ngayNhan=" + ngayNhan + ", ngayGiao="
				+ ngayGiao + ", tongTien=" + tongTien + ", chiTietDonHang=" + chiTietDonHang + ", khachHang="
				+ khachHang + ", trangThai=" + trangThai + "]";
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public NhanSu getNhanVienKD() {
		return NhanVienKD;
	}

	public void setNhanVienKD(NhanSu NhanVienKD) {
		this.NhanVienKD = NhanVienKD;
	}

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public Date getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public ChiTietDonHang getChiTietDonHang() {
		return chiTietDonHang;
	}

	public void setChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		this.chiTietDonHang = chiTietDonHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public TrangThaiDonHang getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiDonHang trangThai) {
		this.trangThai = trangThai;
	}
}
