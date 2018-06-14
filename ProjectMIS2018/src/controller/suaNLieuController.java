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
import dao.NguyenLieuDAO;
import dao.NhaCungCapDAO;
import model.NguyenLieu;


/**
 * Servlet implementation class suaNLieuController
 */
@WebServlet("/suaNLieuController")
public class suaNLieuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public suaNLieuController() {
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
		String maNL = request.getParameter("maNL");
		String tenNL = request.getParameter("tenNL");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		String maLoaiNguyenLieu = request.getParameter("maLoaiNL");
		String maNCC = request.getParameter("maNCC");
		//
		INhaCungCap iNhaCungCap = new NhaCungCapDAO();
		INguyenLieu iNguyenLieu = new NguyenLieuDAO();
		//
		try {
			iNguyenLieu.updateNguyenLieu(maNL, new NguyenLieu(maNL, tenNL, soLuong,
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
