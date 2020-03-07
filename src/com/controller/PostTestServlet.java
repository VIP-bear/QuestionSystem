package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Test;
import com.service.AdmService;
import com.service.UserService;

/**
 * Servlet implementation class PostTestServlet
 */
@WebServlet("/PostTestServlet")
public class PostTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		List<Test> list;
		try {
			String userType = (String)session.getAttribute("userType");		// 获取用户类型
			if (userType.equals("普通用户")) {
				list = UserService.FindAllTest();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/WEB-INF/pages/userPage.jsp").forward(request, response);
			}else {
				list = AdmService.FindAllTest();
				for (Test test : list) {
					test.setUserNumber(AdmService.CountUserNumber(test.getTestid()));
				}
				request.setAttribute("list", list);
				request.getRequestDispatcher("/WEB-INF/pages/adminPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
