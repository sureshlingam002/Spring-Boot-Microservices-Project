package com.suresh.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.departmentservice.dto.DepartmentDto;
import com.suresh.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptservice;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto deptDto)
	{
		return new ResponseEntity<>(deptservice.saveDepartment(deptDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{deptCode}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String deptCode)
	{
		return new ResponseEntity<>(deptservice.getDepartmentByCode(deptCode), HttpStatus.OK);
	}

}
