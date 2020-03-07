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

	//���ҹ���Ա
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
	// ���������Ծ�
	public static List<Test> FindAllTest() throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao  = session.getMapper(AdmDao.class);
		List<Test> list = admDao.findAllTest();
		return list;
	}
	
	//�����ʾ�
	public static void InsertTest(Test test) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.insertTest(test.getTestid(), test.getTesttitle(), test.getDeadline(), test.getQuestionNum());
		session.commit();
		session.close();
	}
	//ɾ���ʾ�
	public static void DeleteTest(Test test) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.deleteTest(test.getTestid());
		session.commit();
		session.close();
	}
	//����ѡ��
	public static void InsertOption(Option option) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.insertOption(option.getOptionid(), option.getQuestionid(), option.getOptionorder(), option.getOptioncontent());
		session.commit();
		session.close();
	}
	//ɾ��ѡ��
	public static void DeleteOption(Option option) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.deleteOption(option.getOptionid(), option.getQuestionid());
		session.commit();
		session.close();
	}
	//��������
	public static void InsertQuestion(Question que) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.insertQuestion(que.getQueid(),que.getQuetitle(), que.getQuetype(), que.getQueorder(), que.getTestid());
		session.commit();
		session.close();
	}
	//ɾ������
	public static void DeleteQuestion(Question que) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.deleteQuestion(que.getQueid());
		session.commit();
		session.close();
	}
	//�޸�����
	public static void ChangeQuestion(String Queid, String Quetitle) throws Exception {
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		admDao.changeQuestion(Queid, Quetitle);
		session.commit();
		session.close();
	}
	//ͳ����Ŀ����
	public static int CountQuestionNumber() throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		int num = admDao.countQuestionNumber();
		return num;

	}
	//ͳ���Ծ�����
	public static int CountTestNumber() throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		int num = admDao.countTestNumber();
		return num;
	}
	//ͳ��ѡ������
	public static int CountOptionNumber() throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		int num = admDao.countOptionNumber();
		return num;
	}
	//ͳ����������
	public static int CountUserNumber(String testid) throws Exception{
		SqlSession session = DBconn.getConntion();
		AdmDao admDao = session.getMapper(AdmDao.class);
		int num = admDao.countUserNumber(testid);
		return num;
	}


}
