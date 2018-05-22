package model;

public class LoaiHang {
	
	private String ma_loaihang;
	private String ten_loaihang;
	
	
	public LoaiHang(String ma_loaihang, String ten_loaihang) {
		this.ma_loaihang = ma_loaihang;
		this.ten_loaihang = ten_loaihang;
	}


	public LoaiHang() {
	}


	public String getMa_loaihang() {
		return ma_loaihang;
	}


	public void setMa_loaihang(String ma_loaihang) {
		this.ma_loaihang = ma_loaihang;
	}


	public String getTen_loaihang() {
		return ten_loaihang;
	}


	public void setTen_loaihang(String ten_loaihang) {
		this.ten_loaihang = ten_loaihang;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}
	

}
