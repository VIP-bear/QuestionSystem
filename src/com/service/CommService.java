package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.CommDao;
import com.domain.Option;
import com.domain.Question;
import com.util.DBconn;

public class CommService {
	
	public static List<Question> FindAllQuestion(String testId) throws Exception{
		SqlSession session = DBconn.getConntion();
		CommDao commDao = session.getMapper(CommDao.class);
		List<Question> list = commDao.findAllQuestion(testId);
		return list;
	}
	
	public static List<Option> FindOptionsByQuestion(String questionid) throws Exception{
		SqlSession session = DBconn.getConntion();
		CommDao userDao = session.getMapper(CommDao.class);
		List<Option> list = userDao.findOptionsByQue(questionid);
		return list;
	}
	
}
