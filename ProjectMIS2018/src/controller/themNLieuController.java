package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.INguyenLieu;
import dao.INhaCungCap;
import dao.NhaCungCapDAO;
import dao.NguyenLieuDAO;
import model.NguyenLieu;

/**
 * Servlet implementation class themNLieuController
 */
@WebServlet("/themNLieuController")
public class themNLieuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themNLieuController() {
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
		String maNL = request.getParameter("maNL");
		String tenNL = request.getParameter("tenNL");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		String maLoaiNguyenLieu = request.getParameter("maLoaiNL");
		String maNCC = request.getParameter("maNCC");
		//
		INhaCungCap iNhaCungCap = new NhaCungCapDAO();
		INguyenLieu iNguyenLieu = new NguyenLieuDAO();
		try {
			iNguyenLieu.themNguyenLieu(new NguyenLieu(maNL, tenNL, soLuong,
					iNguyenLieu.getLoaiNguyenLieu(maLoaiNguyenLieu), iNhaCungCap.getNhaCungCap(maNCC)));
			//
			rd = getServletContext().getRequestDispatcher("/view/nguyenLieu.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
