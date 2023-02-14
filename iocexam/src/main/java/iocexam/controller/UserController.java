package iocexam.controller;

import iocexam.dto.User;
import iocexam.service.UserService;

public class UserController {
	private UserService userService;
	
	public void joinUser() {
		//회원 가입해달라는 요청이 들어오면 요청시 보내준 값을 서비스 쪽에 보내서 회원 가입해달라고 부탁한다. 
		
		User user = new User();
		user.setName("kang");
		user.setEmail("carami@gmail.com");
		user.setPassword("1234");
		
		userService.joinUser(user);
	}

}
