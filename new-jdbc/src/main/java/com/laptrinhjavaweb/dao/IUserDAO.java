package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{
	UserModel findUserNameAndPasswordAndStatus(String userName,String password,Integer status);
}
