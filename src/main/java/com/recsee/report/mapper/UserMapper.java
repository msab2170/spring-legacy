package com.recsee.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.recsee.report.vo.User;

@Mapper
public interface UserMapper {
	
	public List<User> findAllUsers();
	public void insertUser(User user);
	public int numberOfUser();
}
