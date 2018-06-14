package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.INhaCungCap;
import dao.NhaCungCapDAO;
import model.NhaCungCap;

/**
 * Servlet implementation class themNCCController
 */
@WebServlet("/themNCCController")
public class themNCCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themNCCController() {
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
		//
		response.setContentType("text/html;charset=UTF-8");
		//
		RequestDispatcher rd;
		// HttpSession se = request.getSession();
		//
		String maNCC = request.getParameter("maNhaCungCap");
		String ten = request.getParameter("tenNCC");
		String diaChi = request.getParameter("diaChiNCC");
		String email = request.getParameter("emailNCC");
		int dienThoai = Integer.parseInt(request.getParameter("soDienThoai"));
		//
		INhaCungCap iNhaCungCap = new NhaCungCapDAO();
		iNhaCungCap.addNhaCungCap(new NhaCungCap(maNCC, ten, dienThoai, diaChi, email));
		//
		rd = getServletContext().getRequestDispatcher("/view/nhaSanXuat.jsp");
		rd.forward(request, response);
	}

}
