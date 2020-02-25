package com.laptrinhjavaweb.dao.impl;



import java.util.List;



import com.laptrinhjavaweb.dao.INewDao;

import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public class NewDao extends AbstractDAO<NewModel> implements INewDao {
	
	

	@Override
	public List<NewModel> findByCategoryId(long categoryId) {
		String sql="select * from news where categoryid=?";
		return query(sql, new NewMapper(),categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		//String sql="insert into news(title,content,categoryid,createddate,createdby)values(?,?,?,?,?)";
		StringBuilder sql=new StringBuilder("insert into news(title,content,");
		sql.append("thumbnail,shortdescription,categoryid,createddate,createdby)");
		sql.append("values(?,?,?,?,?,?,?)");
		return insert(sql.toString(), newModel.getTitle(),newModel.getContent(),
				newModel.getThumbnail(),newModel.getShortDescription(),newModel.getCategoryId(),
				newModel.getCreatedDate(),newModel.getCreatedBy());
	}

	@Override
	public NewModel findOne(Long id) {
		String sql="select * from news where id=?";
		List<NewModel> news=query(sql, new NewMapper(), id);
		return news.isEmpty() ? null:news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?,modifieddate = ?,modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), 
				updateNew.getCreatedBy(),updateNew.getModifiedDate(),updateNew.getModifiedBy(), updateNew.getId());
		
	}

	@Override
	public void delete(long id) {
String sql="delete from news where id=?";
update(sql, id);
		
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		//String sql ="select * from news";
		//return query(sql, new NewMapper());
		//StringBuilder sql=new StringBuilder("select * from news order by "+sortName+" "+sortBy+" limit "+offset+","+limit+"");
		StringBuilder sql=new StringBuilder("select * from news");
		if(pageble.getSorter()!=null) {
			
			sql.append(" order by "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		
		if(pageble.getOffset()!=null&&pageble.getLimit()!=null) {
			sql.append(" limit "+pageble.getOffset()+" , "+pageble.getLimit()+""); 
			
		}
		return query(sql.toString(), new NewMapper());
		
	
		/*
		
		StringBuilder sql=new StringBuilder("select * from news");
		
		if(offset!=null&&limit!=null) {
			sql.append(" limit ?,?"); 
			return query(sql.toString(), new NewMapper(),offset,limit);
		}else {
			return query(sql.toString(), new NewMapper());
		}
		
			*/
		
		
	}

	@Override
	public int getTotalItem() {
		String sql="select count(*) from news";
		return count(sql);
	}
	}

	
	
