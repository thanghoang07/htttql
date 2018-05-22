package model;

public class LoaiNhanSu {
	
	private String ma_loains;
	private String ten_loains;
	private double luong;

	public LoaiNhanSu() {
	}
	
	public LoaiNhanSu(String ma_loains, String ten_loains, double luong) {
		this.ma_loains = ma_loains;
		this.ten_loains = ten_loains;
		this.luong = luong;
	}
	
	public String getMa_loains() {
		return ma_loains;
	}
	
	public void setMa_loains(String ma_loains) {
		this.ma_loains = ma_loains;
	}
	
	public String getTen_loains() {
		return ten_loains;
	}
	
	public void setTen_loains(String ten_loains) {
		this.ten_loains = ten_loains;
	}
	
	public double getLuong() {
		return luong;
	}
	
	public void setLuong(double luong) {
		this.luong = luong;
	}

	@Override
	public String toString() {
		return "LoaiNhanSu [ma_loains=" + ma_loains + ", ten_loains=" + ten_loains + ", luong=" + luong + "]";
	}
	
	

}
