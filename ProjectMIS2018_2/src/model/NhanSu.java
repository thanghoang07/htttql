package model;

import java.sql.Date;

public class NhanSu {
	
	private String ma_ns;
	private String ten_ns;
	private String ma_loains;
	private Date ngaysinh;
	private boolean gioitinh;
	private String diachi;
	private Date ngayvaolam;
	
	public NhanSu() {}
	
	public NhanSu(String ma_ns, String ten_ns, String ma_loains, Date ngaysinh, boolean gioitinh, String diachi,
			Date ngayvaolam) {
		this.ma_ns = ma_ns;
		this.ten_ns = ten_ns;
		this.ma_loains = ma_loains;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.ngayvaolam = ngayvaolam;
	}

	public String getMa_ns() {
		return ma_ns;
	}

	public void setMa_ns(String ma_ns) {
		this.ma_ns = ma_ns;
	}

	public String getTen_ns() {
		return ten_ns;
	}

	public void setTen_ns(String ten_ns) {
		this.ten_ns = ten_ns;
	}

	public String getMa_loains() {
		return ma_loains;
	}

	public void setMa_loains(String ma_loains) {
		this.ma_loains = ma_loains;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
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

	public Date getNgayvaolam() {
		return ngayvaolam;
	}

	public void setNgayvaolam(Date ngayvaolam) {
		this.ngayvaolam = ngayvaolam;
	}
	
	

}
