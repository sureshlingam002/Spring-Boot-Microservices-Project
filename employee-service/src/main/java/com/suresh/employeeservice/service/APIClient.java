package com.suresh.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.suresh.employeeservice.dto.DepartmentDto;


@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {
	
	@GetMapping("api/departments/{deptCode}")
	DepartmentDto getDepartmentByCode(@PathVariable String deptCode);

}
