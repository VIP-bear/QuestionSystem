package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.domain.Option;
import com.domain.Question;

public interface CommDao {
	
	public List<Question> findAllQuestion(@Param("testId")String testId) throws Exception;
	
	public List<Option> findOptionsByQue(@Param("Questionid")String Questionid) throws Exception;
	
}
