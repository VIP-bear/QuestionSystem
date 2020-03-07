package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.domain.Answer;
import com.domain.Test;
import com.domain.User;

//dao层接口，用于与sql语句直连，实现基本的数据库操作语句

public interface UserDao {
	
	public String findUser(@Param("username")String username, @Param("userpwd")String userpwd)throws Exception;
	
	public List<Test> findAllTest() throws Exception;
	
	public void insertUser(@Param("username")String username, @Param("userpwd")String userpwd) throws Exception;
	
	public void deleteUser(@Param("username")String username, @Param("userpwd")String userpwd) throws Exception;
	
	public User findByUsername(@Param("username")String username)throws Exception;
	
	public void insertAnswer(@Param("username")String username, @Param("Testid")String Testid,
			@Param("Optionorder")String Optionorder, @Param("questionId")String questionId);
	public List<Answer> findAnswerbyTestid(@Param("Username")String Username, @Param("Testid")String Testid);
}
