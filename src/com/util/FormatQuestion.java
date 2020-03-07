package com.util;

import java.util.ArrayList;
import java.util.List;

import com.domain.Option;
import com.domain.Question;

public class FormatQuestion {
	
	public static List<Option> getOption(String text, String questionId, int optionNum) {
		
		List<Option> list = new ArrayList<>();
		String[] allOp = text.split("\n");
		
		for (int i = 1; i < allOp.length-1; i++) {
			Option option = new Option();
			String optionOrder = allOp[i].split("\\.")[0];
			String optionContent = allOp[i].split("\\.")[1];
			option.setOptionid("OPT"+(optionNum+i));
			option.setOptionorder(optionOrder);
			option.setOptioncontent(optionContent);
			option.setQuestionid(questionId);
			list.add(option);
		}
		return list;
	}
	
	public static Question getQuestion(String questionId, String title, String order, String testId) {
		
		Question question = new Question();
		question.setQueid(questionId);
		question.setQuetitle(title);
		question.setQueorder(order);
		question.setTestid(testId);
		return question;
		
	}
	
}
