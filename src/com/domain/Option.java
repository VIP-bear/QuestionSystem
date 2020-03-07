package com.domain;

public class Option {
	private String optionid;
	private String optionorder;
	private String optioncontent;
	private String questionid;
	
	public void setOptionid(String Optionid) {
		optionid = Optionid;
	}
	public String getOptionid() {
		return optionid;
	}
	
	public void setOptionorder(String Optionorder) {
		optionorder = Optionorder;
	}
	public String getOptionorder() {
		return optionorder;
	}
	
	public void setOptioncontent(String Optioncontent) {
		optioncontent = Optioncontent;
	}
	public String getOptioncontent() {
		return optioncontent;
	}
	
	public void setQuestionid(String Questionid) {
		questionid = Questionid;
	}
	public String getQuestionid() {
		return questionid;
	}
	public String toString() {
		return optionorder+"."+optioncontent;
	}
}
