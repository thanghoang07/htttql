package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NhaCungCap;
import model.SanPham;

public class NhaCungCapDAO implements INhaCungCap {

	private static ConnectionPool pool;

	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	@Override
	public List<NhaCungCap> getListNhaCungCap() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from NHACUNGCAP;";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		//
		List<NhaCungCap> list = new ArrayList<NhaCungCap>();
		String maNCC = null, tenNCC = null, diaChi = null, email = null;
		int sdt = 0;
		//
		while (rs.next()) {
			maNCC = rs.getString("MA_NCC");
			tenNCC = rs.getString("TEN_NCC");
			sdt = rs.getInt("SDT");
			email = rs.getString("EMAIL");
			diaChi = rs.getString("DIA_CHI");
			//
			list.add(new NhaCungCap(maNCC, tenNCC, sdt, diaChi, email));
		}

		return list;
	}

	@Override
	public NhaCungCap getNhaCungCap(String maNhaCungCap) throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection con = pool.getConnection();

		String sql = "select * from NHACUNGCAP Where MA_NCC='" + maNhaCungCap + "';";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		//
		String tenNCC = null, diaChi = null, email = null;
		int sdt = 0;
		while (rs.next()) {
			tenNCC = rs.getString("TEN_NCC");
			sdt = rs.getInt("SDT");
			email = rs.getString("EMAIL");
			diaChi = rs.getString("DIA_CHI");
		}

		return new NhaCungCap(maNhaCungCap, tenNCC, sdt, diaChi, email);
	}

}
