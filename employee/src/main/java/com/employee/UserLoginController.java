package com.employee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

	
	
	
	@RequestMapping("/getUserName")
	public String getUserName() {
		
		return "Manoj";
		
	}
	
	@RequestMapping("/getPassword")
	public String getPassword() {
		
		return "ManojPwd";
		
	}
	
	
	@RequestMapping("/getSecretKey")
	public String getSecretKey() {
		
		return "ManojSecretKey";
		
	}
	
	
	@RequestMapping("/getClientId")
	public String getClientId() {
		
		return "ManojClientId";
		
	}
	
}
