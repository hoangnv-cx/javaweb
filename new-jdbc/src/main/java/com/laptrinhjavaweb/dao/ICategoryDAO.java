package com.laptrinhjavaweb.dao;


import java.util.*;

import com.laptrinhjavaweb.model.CategoryModel;



public interface ICategoryDAO extends IGenericDAO<CategoryModel> {
	List <CategoryModel> findAll();

}
