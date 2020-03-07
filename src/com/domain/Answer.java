package com.domain;

public class Answer {

	private String userName;
	
	private String testId;
	
	private String answerContent;
	
	private String questionId;
	
	public Answer() {}
	
	public Answer(String userName, String testId, String answerContent, String questionId) {
		super();
		this.userName = userName;
		this.testId = testId;
		this.answerContent = answerContent;
		this.questionId = questionId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
}
