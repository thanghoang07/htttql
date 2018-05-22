package model;

public class SanPham {
	
	private String ma_sp;
	private String ten_sp;
	private int soluong;
	private double gia;
	private String kichthuoc;
	private String ma_loaihang;
	private String url_hinh;
	
	public SanPham() {
	}

	public SanPham(String ma_sp, String ten_sp, int soluong, double gia, String kichthuoc, String ma_loaihang,
			String url_hinh) {
		this.ma_sp = ma_sp;
		this.ten_sp = ten_sp;
		this.soluong = soluong;
		this.gia = gia;
		this.kichthuoc = kichthuoc;
		this.ma_loaihang = ma_loaihang;
		this.url_hinh = url_hinh;
	}

	public String getMa_sp() {
		return ma_sp;
	}

	public void setMa_sp(String ma_sp) {
		this.ma_sp = ma_sp;
	}

	public String getTen_sp() {
		return ten_sp;
	}

	public void setTen_sp(String ten_sp) {
		this.ten_sp = ten_sp;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getKichthuoc() {
		return kichthuoc;
	}

	public void setKichthuoc(String kichthuoc) {
		this.kichthuoc = kichthuoc;
	}

	public String getMa_loaihang() {
		return ma_loaihang;
	}

	public void setMa_loaihang(String ma_loaihang) {
		this.ma_loaihang = ma_loaihang;
	}

	public String getUrl_hinh() {
		return url_hinh;
	}

	public void setUrl_hinh(String url_hinh) {
		this.url_hinh = url_hinh;
	}
	
	
	
	

}
