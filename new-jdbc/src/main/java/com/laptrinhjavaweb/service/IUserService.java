package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserService {
	UserModel findUserNameAndPasswordAndStatus(String userName,String password,Integer status);
}
