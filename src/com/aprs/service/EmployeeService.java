package com.aprs.service;

import com.aprs.entity.Employee;

public interface EmployeeService {
	public Employee login(String id,String password);
	public void change(Employee admin);
}
