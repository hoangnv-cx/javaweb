package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtils;

@WebServlet(urlPatterns = "/admin-new")
public class NewController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Inject
	private INewService newservice;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewModel model = FormUtils.toModel(NewModel.class, request);
		
		
		Pageble pageble=new PageRequest(model.getPage(),model.getMaxPage(), 
				
				new Sorter(model.getSortName(), model.getSortBy()));
		model.setListResult(newservice.findAll(pageble));
		model.setTotalItem(newservice.getTotalItem());
		model.setTotalPages((int) Math.ceil((double) model.getTotalItem() / model.getMaxPage()));
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest repuest, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
