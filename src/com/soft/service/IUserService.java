package com.soft.service;

import com.soft.entity.User;

public interface IUserService {
	
	public void addUser(User user);
	
	public boolean login(User user);

}
