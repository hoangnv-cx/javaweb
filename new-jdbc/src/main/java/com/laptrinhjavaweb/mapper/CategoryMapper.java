package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;


public class CategoryMapper  implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel rowMap(ResultSet results) {

		try {
			CategoryModel cm=new CategoryModel();
			cm.setId(results.getLong("id"));
			cm.setCode(results.getString("code"));
			cm.setName(results.getString("name"));
			return cm;
				
		
				
			
		
		} catch (SQLException e) {
			
			return null;
		}

	}

}
