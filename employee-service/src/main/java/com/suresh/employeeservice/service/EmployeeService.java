package com.suresh.employeeservice.service;

import com.suresh.employeeservice.dto.APIResponseDto;
import com.suresh.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	APIResponseDto getEmployeeById(Long id);

}
