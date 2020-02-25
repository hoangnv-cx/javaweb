package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDao;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService{
	@Inject
	private INewDao newdao;
	@Override
	public List<NewModel> findByCategoryId(long categoryid) {
		
		return newdao.findByCategoryId(categoryid);
	}
	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
	Long newId=newdao.save(newModel);
	
		return newdao.findOne(newId);
	}
	@Override
	public NewModel update(NewModel updateNew) {
		NewModel olModel=newdao.findOne(updateNew.getId());
		updateNew.setCreatedDate(olModel.getCreatedDate());
		updateNew.setCreatedBy(olModel.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newdao.update(updateNew);
		return newdao.findOne(updateNew.getId());
	}
	@Override
	public void delete(long[] ids) {
		for(long id:ids) {
			newdao.delete(id);
		}
		
	}
	@Override
	public List<NewModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return newdao.findAll(pageble);
	}
	@Override
	public int getTotalItem() {
		
		return newdao.getTotalItem();
	}

}
