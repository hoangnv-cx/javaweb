package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel rowMap(ResultSet results) {
	
		try {
			
			UserModel user=new UserModel();
			user.setId(results.getLong("id"));
			user.setUserName(results.getString("userName"));
			user.setPassword(results.getString("password"));
			user.setStatus(results.getInt("status"));
			user.setFullName(results.getString("fullName"));
				try {
					RoleModel role=new RoleModel();
					role.setCode(results.getString("code"));
					role.setName(results.getString("name"));
					user.setRole(role);
				}catch (Exception e){
					System.out.println(e.getMessage());
				}
				return user;
			
				
			
		
		} catch (SQLException e) {
			
			return null;
		}
	
	}

}