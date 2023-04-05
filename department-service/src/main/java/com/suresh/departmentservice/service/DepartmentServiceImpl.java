package com.suresh.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.departmentservice.dto.DepartmentDto;
import com.suresh.departmentservice.entity.Department;
import com.suresh.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto)
	{
		Department dept = new Department();
		
		dept.setCode(departmentDto.getDepartmentCode());
		dept.setDescription(departmentDto.getDepartmentDescription());
		dept.setName(departmentDto.getDepartmentName());
		
		Department savedDpt = departmentRepository.save(dept);
		
		DepartmentDto dto = new DepartmentDto();
		dto.setDepartmentCode(savedDpt.getCode());
		dto.setDepartmentDescription(savedDpt.getDescription());
		dto.setDepartmentName(savedDpt.getName());
		dto.setDepartmentId(savedDpt.getId());
		
		return dto;
	}
	
	@Override
	public DepartmentDto getDepartmentByCode(String deptCode)
	{
		Department dept = departmentRepository.findByCode(deptCode);
		
		DepartmentDto dto = new DepartmentDto();
		dto.setDepartmentCode(dept.getCode());
		dto.setDepartmentDescription(dept.getDescription());
		dto.setDepartmentId(dept.getId());
		dto.setDepartmentName(dept.getName());
		
		return dto;
	}
	
	
}
