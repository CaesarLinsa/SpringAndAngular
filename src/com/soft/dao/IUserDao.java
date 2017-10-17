package com.soft.dao;

import java.util.List;

import com.soft.entity.User;

public interface IUserDao {
	
	public void addUser(User user);
	public List<User> checkUser(User user);

}
