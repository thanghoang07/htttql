package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonHangDAO;
import dao.IDonHang;
import model.SanPham;

/**
 * Servlet implementation class suaSPController
 */
@WebServlet("/suaSPController")
public class suaSPController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public suaSPController() {
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
		String maSP = request.getParameter("maSP");
		String tenSP = request.getParameter("tenSP");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		float gia = Float.parseFloat(request.getParameter("gia"));
		String kichThuoc = request.getParameter("kichThuoc");
		String maLoaiHang = request.getParameter("maLoaiHang");
		String hinh = request.getParameter("hinh");
		//
		IDonHang iDonHang = new DonHangDAO();
		try {
			iDonHang.suaSanPham(maSP,
					new SanPham(maSP, tenSP, soLuong, gia, kichThuoc, iDonHang.getLoaiHang(maLoaiHang), hinh));
			rd = getServletContext().getRequestDispatcher(
					"/view/quanlysanpham.jsp?maLoaiHang=" + iDonHang.getLoaiHang(maLoaiHang).getMa_loaihang() + "");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
