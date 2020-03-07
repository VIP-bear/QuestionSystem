package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.AdmDao;
import com.util.DBconn;
import com.domain.Option;
import com.domain.Question;
import com.domain.Test;
import com.domain.User;

public class AdmService {

	//查找管理员
	public static boolean FindAdm(User adm) throws Exception{
		SqlSession session = DBconn.getConntion();
        AdmDao admDao = session.getMapper(AdmDao.class);
        String administrator = admDao.findAdm(adm.getUserName(), adm.getPassword());
        
        session.close();
        
        if(administrator != null) {
	        return true;
        }
        else {
	        return false;
        }
	}
	// 查找所有试卷
	public static List<Test> FindAllTest() throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao  = session.getMapper(AdmDao.class);
		List<Test> list = admDao.findAllTest();
		return list;
	}
	
	//插入问卷
	public static void InsertTest(Test test) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.insertTest(test.getTestid(), test.getTesttitle(), test.getDeadline(), test.getQuestionNum());
		session.commit();
		session.close();
	}
	//删除问卷
	public static void DeleteTest(Test test) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.deleteTest(test.getTestid());
		session.commit();
		session.close();
	}
	//插入选项
	public static void InsertOption(Option option) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.insertOption(option.getOptionid(), option.getQuestionid(), option.getOptionorder(), option.getOptioncontent());
		session.commit();
		session.close();
	}
	//删除选项
	public static void DeleteOption(Option option) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.deleteOption(option.getOptionid(), option.getQuestionid());
		session.commit();
		session.close();
	}
	//插入问题
	public static void InsertQuestion(Question que) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.insertQuestion(que.getQueid(),que.getQuetitle(), que.getQuetype(), que.getQueorder(), que.getTestid());
		session.commit();
		session.close();
	}
	//删除问题
	public static void DeleteQuestion(Question que) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.deleteQuestion(que.getQueid());
		session.commit();
		session.close();
	}
	//修改问题
	public static void ChangeQuestion(String Queid, String Quetitle) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.changeQuestion(Queid, Quetitle);
		session.commit();
		session.close();
	}
	//统计题目数量
	public static int CountQuestionNumber() throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		int num = admDao.countQuestionNumber();
		return num;

	}
	//统计试卷数量
	public static int CountTestNumber() throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		int num = admDao.countTestNumber();
		return num;
	}
	//统计选项数量
	public static int CountOptionNumber() throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		int num = admDao.countOptionNumber();
		return num;
	}
	//统计做题人数
	public static int CountUserNumber(String testid) throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		int num = admDao.countUserNumber(testid);
		return num;
	}


}
