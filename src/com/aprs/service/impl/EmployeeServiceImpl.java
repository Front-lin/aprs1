package com.aprs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.EmployeeDao;
import com.aprs.entity.Employee;
import com.aprs.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;
	
	public Employee login(String id, String password) {
		// TODO Auto-generated method stub
		return employeeDao.login(id,password);
	}

	@Override
	public void change(Employee admin) {
		// TODO Auto-generated method stub

		employeeDao.change(admin);
	}

}
