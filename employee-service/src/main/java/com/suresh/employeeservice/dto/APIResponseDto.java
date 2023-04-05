package com.suresh.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {
	
	private DepartmentDto deptDto;
	private EmployeeDto employeeDto;
	private OrganizationDto organizationDto;

}
