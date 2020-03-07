package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.util.DBconn;
import com.dao.UserDao;
import com.domain.Answer;
import com.domain.Test;
import com.domain.User;

public class UserService {

	public static boolean FindUser(User user) throws Exception{

		SqlSession session = DBconn.getConntion();
		UserDao userDao = session.getMapper(UserDao.class);
		String judge = userDao.findUser(user.getUserName(), user.getPassword());

		session.close();

		if (judge == null) {
			return false;
		}else {
			return true;
		}

	}
	
	// 查找所有试卷
	public static List<Test> FindAllTest() throws Exception{
		SqlSession session = DBconn.getConntion();
		UserDao userDao  = session.getMapper(UserDao.class);
		List<Test> list = userDao.findAllTest();
		return list;
	}

	public static void InsertUser(User user) throws Exception{
		
		SqlSession session = DBconn.getConntion();
		UserDao mapper = session.getMapper(UserDao.class);
		mapper.insertUser(user.getUserName(), user.getPassword());
		session.commit();
		session.close();
	}

	public static void DeleteUser(User user)throws Exception {
		
		SqlSession session = DBconn.getConntion();
		UserDao userDao = session.getMapper(UserDao.class);
		userDao.deleteUser(user.getUserName(), user.getPassword());
		session.commit();
		session.close();
	}

	public static boolean FindByUsername(String username) throws Exception{

		SqlSession session = DBconn.getConntion();
		UserDao userDao = session.getMapper(UserDao.class);
		User u = userDao.findByUsername(username);

		session.close();

		if (u == null) {
			return false;
		}else {
			return true;
		}
	}
	
	//添加答案
	public static void InsertAnswer(Answer answer)throws Exception {
		SqlSession session = DBconn.getConntion();
		UserDao userDao = session.getMapper(UserDao.class);
		userDao.insertAnswer(answer.getUserName(), answer.getTestId(), answer.getAnswerContent(), answer.getQuestionId());
		session.commit();
		session.close();
	}
	
	// 查找答案
	public static List<Answer> FindAnswerbyTestid(String username, String testid) throws Exception{
		SqlSession session = DBconn.getConntion();
		UserDao userDao = session.getMapper(UserDao.class);
		List<Answer> list = userDao.findAnswerbyTestid(username, testid);
		return list;
	}

	
}