package com.soft.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.dao.IUserDao;
import com.soft.entity.User;

@Service
public class UserService implements IUserService{
	
    @Resource
	private IUserDao iua;
	@Override
	public void addUser(User user) {
		
		iua.addUser(user);
	}
	
	public boolean  login(User user){
		
		List<User> list = iua.checkUser(user);
		
		if(list.size()!=0)
			 return true;
		
		return false;	
	}
   
	
	public User findUserByUserName(String userName){
				
		User user = iua.findUserbyUserName(userName);
		
		if(user!=null){
			return user;
		}
       
		return null;
	}
	
}
