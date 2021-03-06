package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThongKeSoLuongDonHangTheoTTDH {
	private static ConnectionPool pool;

	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver", password = "Aimondo08",
			user = "sa",
			url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYMOC;useUnicode=true;characterEncoding=UTF-8;";

	public ThongKeSoLuongDonHangTheoTTDH() {
	}

	public ArrayList<String> layMATTDH() throws ClassNotFoundException, SQLException {
		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection conn = pool.getConnection();

		String sql = "SELECT DONHANG.MA_TTDH FROM DONHANG INNER JOIN TRANGTHAIDH ON TRANGTHAIDH.MA_TTDH = DONHANG.MA_TTDH GROUP BY DONHANG.MA_TTDH;";

		ArrayList<String> listMATTDH = new ArrayList<String>();

		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String mattdh = rs.getString("MA_TTDH");
			listMATTDH.add(mattdh);
		}

		conn.close();

		return listMATTDH;

	}

	public int thongkeDonHangTheoMATTDH(String ma_ttdh) throws ClassNotFoundException, SQLException {

		pool = new ConnectionPool(url, user, password, driver, 10, 5);
		Connection conn = pool.getConnection();


		String sql = "SELECT COUNT(DONHANG.MA_TTDH) AS SOLUONGDONHANGTHEOMATTDH FROM DONHANG INNER JOIN TRANGTHAIDH ON TRANGTHAIDH.MA_TTDH = DONHANG.MA_TTDH WHERE DONHANG.MA_TTDH = '"
				+ ma_ttdh + "';";

		PreparedStatement ps = conn.prepareStatement(sql);

		int countDHMATTDH = 0;

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			countDHMATTDH = rs.getInt("SOLUONGDONHANGTHEOMATTDH");
		}

		conn.close();

		return countDHMATTDH;

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ThongKeSoLuongDonHangTheoTTDH tk1 = new ThongKeSoLuongDonHangTheoTTDH();

		ArrayList<String> listMATTDH = new ArrayList<String>();

		listMATTDH = tk1.layMATTDH();

		for (String mattdh : listMATTDH) {
			System.out.print(mattdh + "\n");
		}

		for (String mattdh1 : listMATTDH) {
			int count = tk1.thongkeDonHangTheoMATTDH(mattdh1);
			System.out.print(count + "\n");
		}

	}

}
