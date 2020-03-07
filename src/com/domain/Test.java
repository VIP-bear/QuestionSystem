package com.domain;

public class Test {
	private String testid;
	private String testtitle;
	private String deadline;
	private String datetime;
	private int questionNum;
	private int userNumber;
	
	public void setTestid(String Testid) {
		testid = Testid;
	}
	public String getTestid() {
		return testid;
	}
	
	public void setTesttitle(String Testtitle) {
		testtitle = Testtitle;
	}
	public String getTesttitle() {
		return testtitle;
	}
	
	public void setDeadline(String Deadline) {
		deadline = Deadline;
	}
	public String getDeadline() {
		return deadline;
	}
	
	public void setDatetime(String Datetime) {
		datetime = Datetime;
	}
	public String getDatetime() {
		return datetime;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
}
