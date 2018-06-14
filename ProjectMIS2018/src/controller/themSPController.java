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
import feature.AutoID;
import model.SanPham;

/**
 * Servlet implementation class themSPController
 */
@WebServlet("/themSPController")
public class themSPController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themSPController() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		//
		RequestDispatcher rd;
		// HttpSession se = request.getSession();
		//
		String tenSP = request.getParameter("tenSP");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		int gia = Integer.parseInt(request.getParameter("gia"));
		String kichThuoc = request.getParameter("kichThuoc");
		String maLoaiHang = request.getParameter("maLoaiHang");
		String hinh = request.getParameter("hinh");
		//
		IDonHang iDonHang = new DonHangDAO();
		AutoID autoID = new AutoID();
		try {
			iDonHang.themSanPham(new SanPham(autoID.autoMaSanPham(maLoaiHang), tenSP, soLuong, gia, kichThuoc,
					iDonHang.getLoaiHang(maLoaiHang), hinh));
			rd = getServletContext().getRequestDispatcher(
					"/view/quanlysanpham.jsp?maLoaiHang=" + iDonHang.getLoaiHang(maLoaiHang).getMa_loaihang() + "");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
