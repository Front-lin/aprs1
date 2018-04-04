package com.aprs.dao;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Employee;

public interface EmployeeDao {
	public Employee login(@Param("employee_id")String id,@Param("password")String password);
	public void change(Employee admin);
}
