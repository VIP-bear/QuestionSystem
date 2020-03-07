package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Option;
import com.domain.Question;
import com.domain.Test;
import com.service.AdmService;
import com.util.FormatQuestion;

/**
 * Servlet implementation class SaveTestServlet
 */
@WebServlet("/SaveTestServlet")
public class SaveTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int queNum = (int)request.getSession().getAttribute("queNum");		// ��ȡ��Ŀ����
		try {
			int testNum = AdmService.CountTestNumber();			// ��ȡ�Ծ�����
			int queAllNum = AdmService.CountQuestionNumber();	// ��ȡ��Ŀ������
			int AllOptionNum = AdmService.CountOptionNumber();		// ��ȡѡ������
			String testTitle = (String)request.getSession().getAttribute("testTitle");	// ��ȡ�Ծ����
			String dateLine = (String)request.getSession().getAttribute("dateLine");		// ��ȡʱ���ֹ����
		
			
			Test test = new Test();
			test.setTestid("TEST"+(testNum+1));
			test.setTesttitle(testTitle);
			test.setDeadline(dateLine);
			test.setQuestionNum(queNum);
			AdmService.InsertTest(test);  		// ����Ծ�
			
			for (int i = 1; i <= queNum; i++) {
				String text = request.getParameter(String.valueOf(i));
				System.out.println(text);
				Question question = FormatQuestion.getQuestion("QUE"+(queAllNum+i), text.split("\n")[0],
						String.valueOf(i), test.getTestid());
				AdmService.InsertQuestion(question);	// �����Ŀ
				
				List<Option> listOption = FormatQuestion.getOption(text, "QUE"+(queAllNum+i), AllOptionNum);
				for (Option option : listOption) {
					AdmService.InsertOption(option);
				}
				AllOptionNum += listOption.size();
			}
			
			request.getRequestDispatcher("/QuestionSystem/PostTestServlet")
			.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		// ��ȡ�Ծ�����
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
