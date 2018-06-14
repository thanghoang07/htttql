package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonHangDAO;
import dao.IDonHang;
import dao.IKhachHang;
import dao.INhanSu;
import dao.KhachHangDAO;
import dao.NhanSuDAO;
import feature.AutoID;
import feature.TongTienDonHang;
import model.ChiTietDonHang;
import model.DonHang;
import model.SanPham;

/**
 * Servlet implementation class suaDHController
 */
@WebServlet("/suaDHController")
public class suaDHController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public suaDHController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//
		RequestDispatcher rd;
		//
		//
		String maDonHang = request.getParameter("maDonHang");
		String maNS = request.getParameter("maNS");
		String maKH = request.getParameter("maKH");
		Date ngayNhan = Date.valueOf(request.getParameter("ngayNhan"));
		Date ngayGiao = Date.valueOf(request.getParameter("ngayGiao"));
		String maSP1 = request.getParameter("maSP1");
		String maSP2 = request.getParameter("maSP2");
		String maSP3 = request.getParameter("maSP3");
		String maSP4 = request.getParameter("maSP4");
		String maSP5 = request.getParameter("maSP5");
		int soluong1 = Integer.parseInt(request.getParameter("soLuong1"));
		int soluong2 = Integer.parseInt(request.getParameter("soLuong2"));
		int soluong3 = Integer.parseInt(request.getParameter("soLuong3"));
		int soluong4 = Integer.parseInt(request.getParameter("soLuong4"));
		int soluong5 = Integer.parseInt(request.getParameter("soLuong5"));
		//
		IKhachHang iKhachHang = new KhachHangDAO();
		IDonHang iDonHang = new DonHangDAO();
		INhanSu iNhanSu = new NhanSuDAO();
		AutoID autoID = new AutoID();
		TongTienDonHang tongTienDH = new TongTienDonHang();
		HashMap<SanPham, Integer> ctdh = new HashMap<SanPham, Integer>();
		//
		try {
			ctdh.put(iDonHang.getSanPham(maSP1), soluong1);
			ctdh.put(iDonHang.getSanPham(maSP2), soluong2);
			ctdh.put(iDonHang.getSanPham(maSP3), soluong3);
			ctdh.put(iDonHang.getSanPham(maSP4), soluong4);
			ctdh.put(iDonHang.getSanPham(maSP5), soluong5);
			//
			iDonHang.themDonHang(new DonHang(maDonHang, iNhanSu.getNhanSu(maNS), ngayNhan, ngayGiao,
					tongTienDH.tongTien(ctdh), new ChiTietDonHang(maDonHang, ctdh), iKhachHang.getKhachHang(maKH),
					iDonHang.getTrangThai("CG")));
			//
			rd = getServletContext().getRequestDispatcher("/view/donHang.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
