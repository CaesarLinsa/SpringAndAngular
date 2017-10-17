package com.soft.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.soft.entity.ParamsBody;
import com.soft.entity.ReturnBody;
import com.soft.entity.User;
import com.soft.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	 
	 @Resource
     private UserService us;
	 
	 @RequestMapping(value="/add",method=RequestMethod.POST)
	 
	 public @ResponseBody void  addUser( @RequestBody ParamsBody body,HttpServletRequest request){
		 System.out.println(body);
//		 us.addUser(user);
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
