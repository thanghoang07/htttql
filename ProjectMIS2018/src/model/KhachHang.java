package model;

public class KhachHang {

	private String ma_kh;
	private String ten_kh;
	private boolean gioitinh;
	private String diachi;
	private int sdt;

	public KhachHang(String ma_kh, String ten_kh, boolean gioitinh, String diachi, int sdt) {
		this.ma_kh = ma_kh;
		this.ten_kh = ten_kh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sdt = sdt;
	}

	public KhachHang() {
	}

	public String getMa_kh() {
		return ma_kh;
	}

	public void setMa_kh(String ma_kh) {
		this.ma_kh = ma_kh;
	}

	public String getTen_kh() {
		return ten_kh;
	}

	public void setTen_kh(String ten_kh) {
		this.ten_kh = ten_kh;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "KhachHang [ma_kh=" + ma_kh + ", ten_kh=" + ten_kh + ", gioitinh=" + gioitinh + ", diachi=" + diachi
				+ ", sdt=" + sdt + "]";
	}

}
