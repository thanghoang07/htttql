package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IKhachHang;
import dao.KhachHangDAO;
import feature.AutoID;
import model.KhachHang;

/**
 * Servlet implementation class themKHController
 */
@WebServlet("/themKHController")
public class themKHController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themKHController() {
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
		// doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		//
		RequestDispatcher rd;
		// HttpSession se = request.getSession();
		//
		String tenKH = request.getParameter("tenKH");
		String diaChiKH = request.getParameter("diaChiKH");
		Boolean gioiTinhKH = Boolean.valueOf(request.getParameter("gioiTinh"));
		int soDienThoai = Integer.parseInt(request.getParameter("soDienThoai"));
		//
		IKhachHang iKhachHang = new KhachHangDAO();
		AutoID autoID = new AutoID();
		//
		try {
			iKhachHang.addKhachHang(new KhachHang(autoID.autoMaKhachHang(), tenKH, gioiTinhKH, diaChiKH, soDienThoai));
			//
			rd = getServletContext().getRequestDispatcher("/view/khachHang.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
