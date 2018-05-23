package model;

import java.sql.Date;

public class NhanVienKho extends NhanSu {

	public NhanVienKho(String maNS, String tenNS, Date ngaySinh, String diaChi, Boolean gioiTinh, Date ngayVaoLam,
			LoaiNhanSu loai) {
		super(maNS, tenNS, ngaySinh, diaChi, gioiTinh, ngayVaoLam, loai);
		// TODO Auto-generated constructor stub
	}

	public void lapDonDeNghi() {
	}

}
