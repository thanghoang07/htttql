package dao;

import java.sql.SQLException;
import java.util.List;

import model.NhaCungCap;

public interface INhaCungCap {
	public List<NhaCungCap> getListNhaCungCap() throws ClassNotFoundException, SQLException;

	public NhaCungCap getNhaCungCap(String maNhaCungCap) throws ClassNotFoundException, SQLException;
}
