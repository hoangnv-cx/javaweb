package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel rowMap(ResultSet results) {



try {
	
	NewModel news=new NewModel();
		news.setId(results.getLong("id"));
		news.setTitle(results.getString("title"));
		news.setContent(results.getString("content"));
		news.setCategoryId(results.getLong("categoryid"));
		news.setThumbnail(results.getString("thumbnail"));
		news.setShortDescription(results.getString("shortdescription"));
		news.setCreatedDate(results.getTimestamp("createddate"));
		news.setCreatedBy(results.getString("createdby"));
		if(results.getTimestamp("modifieddate")!=null) {
			news.setModifiedDate(results.getTimestamp("modifieddate"));
		}
		if(results.getString("modifiedby")!=null) {
			news.setModifiedBy(results.getString("modifiedby"));
		}

		return news;
	
		
	

} catch (SQLException e) {
	
	return null;
}

}

}

