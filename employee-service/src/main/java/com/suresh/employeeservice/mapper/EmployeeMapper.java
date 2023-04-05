package com.suresh.employeeservice.mapper;

import org.springframework.stereotype.Service;

import com.suresh.employeeservice.dto.EmployeeDto;
import com.suresh.employeeservice.entity.Employee;

@Service
public class EmployeeMapper {
	
	public Employee mapToEmployee(EmployeeDto employeeDto)
	{
		Employee employee = new Employee();
		employee.setEmail(employeeDto.getEmail());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setDepartmentCode(employeeDto.getDepartmentCode());
		employee.setOrganizationCode(employeeDto.getOrganizationCode());
		
		return employee;
	}
	
	public EmployeeDto mapToEmployeeDto(Employee employee)
	{
		EmployeeDto edto = new EmployeeDto();
		edto.setEmail(employee.getEmail());
		edto.setFirstName(employee.getFirstName());
		edto.setLastName(employee.getLastName());
		edto.setId(employee.getId());
		edto.setDepartmentCode(employee.getDepartmentCode());
		edto.setOrganizationCode(employee.getOrganizationCode());
		
		return edto;
	}

}
