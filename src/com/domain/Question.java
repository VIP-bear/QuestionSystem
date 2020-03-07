package com.domain;

import java.util.List;

public class Question {
	private String questionid;
	private String questiontitle;
	private String questiontype;
	private String questionorder;
	private String testid;
	public List<Option> optionList;
	
	public String getQueid() {
		return questionid;
	}
	public void setQueid(String Queid) {
		questionid = Queid;
	}
	
	public String getQuetitle() {
		return questiontitle;
	}
	public void setQuetitle(String Quetitle) {
		questiontitle = Quetitle;
	}
	
	public String getQuetype() {
		return questiontype;
	}
	public void setQuetype(String Quetype) {
		questiontype = Quetype;
	}
	
	public String getQueorder() {
		return questionorder;
	}
	public void setQueorder(String Queorder) {
		questionorder = Queorder;
	}
	
	public String getTestid() {
		return testid;
	}
	public void setTestid(String Testid) {
		testid = Testid;
	}
	public String toString() {
		String result = this.getQueorder() + ". " + this.getQuetitle() + "\n";
		return result;
	}
	public List<Option> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}
}
