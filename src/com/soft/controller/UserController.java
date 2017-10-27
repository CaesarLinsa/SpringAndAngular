package com.soft.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.soft.entity.ReturnBody;
import com.soft.entity.User;
import com.soft.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	 
	 @Resource
     private UserService us;
	 

	 @RequestMapping(value="/add",method=RequestMethod.GET)
	 @ResponseBody 
	 public void  addUser(@RequestBody User user){
		 System.out.println(user);
         us.addUser(user);
	 }
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody ReturnBody login( User user){
		ReturnBody body=new ReturnBody();
		System.out.println(user);
		if(us.login(user)){
			body.setMsg("登录成功");
		}else{
			body.setMsg("登录失败");
		}
		return body;
	}	
	
}
