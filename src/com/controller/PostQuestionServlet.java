package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Question;
import com.service.CommService;
import com.util.CommVar;

/**
 * Servlet implementation class PostQuestionServlet
 */
@WebServlet("/PostQuestionServlet")
public class PostQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		String testId = request.getParameter("testId");
		session.setAttribute("testIdForAsw", testId);
		List<Question> list;
		try {
			CommVar.questionList = CommService.FindAllQuestion(testId);
			list = CommVar.questionList;
			for (Question question : list) {
				question.setOptionList(CommService.FindOptionsByQuestion(question.getQueid()));
			}
			request.setAttribute("questionlist", list);
			
			String userType = (String)session.getAttribute("userType");
			if (userType.equals("∆’Õ®”√ªß")) {
				request.getRequestDispatcher("/question.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/update.jsp").forward(request, response);
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
