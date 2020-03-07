package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.User;
import com.service.AdmService;
import com.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("uname");	// ��ȡ�û���
		String userPwd = request.getParameter("pwd");		// ��ȡ����
		String userType = request.getParameter("Type");		// ��ȡ�û�����
		
		HttpSession session = request.getSession();
		session.setAttribute("userType", userType);			
		
		User loginUser = new User(userName, userPwd);
		
		if (userType.equals("��ͨ�û�")) {
			UserService userService = new UserService();
			try {
				if (userService.FindUser(loginUser)) {
					session.setAttribute("userName", userName);
					request.setAttribute("username", userName);
					request.getRequestDispatcher("/QuestionSystem/PostTestServlet")
					.forward(request, response);
				}else {
					response.sendRedirect("login.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			AdmService admServer = new AdmService();
			try {
				loginUser.setUserName(userName);
				loginUser.setPassword(userPwd);
				if (admServer.FindAdm(loginUser)) {
					request.getRequestDispatcher("/QuestionSystem/PostTestServlet")
					.forward(request, response);
				}else {
					response.sendRedirect("login.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
