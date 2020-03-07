package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Answer;
import com.domain.Question;
import com.service.UserService;
import com.util.CommVar;

/**
 * Servlet implementation class SaveOrderServlet
 */
@WebServlet("/SaveOrderServlet")
public class SaveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveOrderServlet() {
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
		String userName = (String)session.getAttribute("userName");
		String testId = (String)session.getAttribute("testIdForAsw");
		
		List<Question> list = CommVar.questionList;
		String answerContent;
		Answer answer = new Answer();
		answer.setUserName(userName);
		answer.setTestId(testId);
			
		for (Question question : list) {
			answer.setQuestionId(question.getQueid());
			answer.setAnswerContent(request.getParameter(question.getQueid()));
			try {
				UserService.InsertAnswer(answer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher("/QuestionSystem/PostTestServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
