package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.domain.Test;

public interface AdmDao {
	
	public String findAdm(@Param("admname")String admname, @Param("admpwd")String admpwd)throws Exception;
	
	public List<Test> findAllTest() throws Exception;
	
	public void insertTest(@Param("id")String id, @Param("title")String title, @Param("deadline")String deadline, @Param("Quenum")int Quenum); 
	
	public void deleteTest(@Param("id")String id);
	
	public void insertOption(@Param("Optionid")String Optionid, @Param("Questionid")String Questionid, @Param("Optionorder")String order,@Param("content")String content);
	
	public void deleteOption(@Param("Optionid")String Optionid, @Param("Questionid")String Questionid);
	
	public void insertQuestion(@Param("Queid")String Queid, @Param("Quetitle")String Quetitle, @Param("Quetype")String Quetype, @Param("Queorder")String Queorder,@Param("Testid")String Testid);
	
	public void deleteQuestion(@Param("Queid")String Queid);
	
	public void changeQuestion(@Param("Queid")String Queid, @Param("Quetitle")String Quetitle);
	
	public int countQuestionNumber();
	
	public int countTestNumber();

	public int countOptionNumber();
	
	public int countUserNumber(@Param("Testid")String Testid);


}
