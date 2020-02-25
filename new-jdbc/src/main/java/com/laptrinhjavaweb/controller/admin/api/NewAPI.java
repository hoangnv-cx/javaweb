package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.HttpUtil;
@WebServlet(urlPatterns = "/api-admin-new")
public class NewAPI extends HttpServlet{

	@Inject
	private INewService newService;
	private static final long serialVersionUID = -915988021506484384L;
	
protected void doPost(HttpServletRequest repuest,HttpServletResponse response) throws ServletException ,IOException {
	ObjectMapper mapper=new ObjectMapper();
		repuest.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel newModel =HttpUtil.of(repuest.getReader()).toModel(NewModel.class);
		newModel=newService.save(newModel);
		mapper.writeValue(response.getOutputStream(), newModel);
		System.out.println(newModel);
	}
protected void doPut(HttpServletRequest repuest,HttpServletResponse response) throws ServletException ,IOException {
	ObjectMapper mapper=new ObjectMapper();
	repuest.setCharacterEncoding("UTF-8");
	response.setContentType("application/json");
	NewModel updateNew =HttpUtil.of(repuest.getReader()).toModel(NewModel.class);
	updateNew=newService.update(updateNew);
	mapper.writeValue(response.getOutputStream(), updateNew);
	System.out.println(updateNew);
}
protected void doDelete(HttpServletRequest repuest,HttpServletResponse response) throws ServletException ,IOException {
	ObjectMapper mapper=new ObjectMapper();
	repuest.setCharacterEncoding("UTF-8");
	response.setContentType("application/json");
	NewModel newModel =HttpUtil.of(repuest.getReader()).toModel(NewModel.class);
	newService.delete(newModel.getIds());
	mapper.writeValue(response.getOutputStream(), "{}");
}

}
