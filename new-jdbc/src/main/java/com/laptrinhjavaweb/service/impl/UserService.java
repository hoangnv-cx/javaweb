package com.laptrinhjavaweb.service.impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{
@Inject
private IUserService userService;
	@Override
	public UserModel findUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		
		return userService.findUserNameAndPasswordAndStatus(userName, password, status);
	}

}
