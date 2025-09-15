package com.service;
import com.dao.EmployeeDao;

public class EmployeeService 
{
	public void insertData() throws Exception
	{
		EmployeeDao dao = new EmployeeDao();
		dao.insertData();
		
	}
	
	public void getSingleData() throws Exception
	{
		EmployeeDao dao = new EmployeeDao();
		dao.getSingleData();
	}
	
	public void getAllData() throws Exception
	{
		EmployeeDao dao = new EmployeeDao();
		dao.getAllData();
	}
	
	public void updateData() throws Exception
	{
		EmployeeDao dao = new EmployeeDao();
		dao.updateData();
	}
	
	public void deleteSingleData() throws Exception
	{
		EmployeeDao dao = new EmployeeDao();
		dao.deleteSingleData();
	}
}
