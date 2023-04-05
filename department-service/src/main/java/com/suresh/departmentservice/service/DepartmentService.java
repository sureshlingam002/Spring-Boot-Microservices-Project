package com.suresh.departmentservice.service;

import com.suresh.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto saveDepartment(DepartmentDto deptDto);
	
	DepartmentDto getDepartmentByCode(String deptCode);

}
