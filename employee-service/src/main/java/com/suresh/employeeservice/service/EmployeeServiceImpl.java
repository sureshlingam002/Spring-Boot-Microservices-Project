package com.suresh.employeeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.suresh.employeeservice.dto.APIResponseDto;
import com.suresh.employeeservice.dto.DepartmentDto;
import com.suresh.employeeservice.dto.EmployeeDto;
import com.suresh.employeeservice.dto.OrganizationDto;
import com.suresh.employeeservice.entity.Employee;
import com.suresh.employeeservice.mapper.EmployeeMapper;
import com.suresh.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;
	
//	@Autowired
//	private APIClient feignClient;
	
	@Autowired
	private EmployeeMapper mapper;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
			
		EmployeeDto edto  = mapper.mapToEmployeeDto(employeeRepository.save(mapper.mapToEmployee(employeeDto)));

		return edto;
	}

	@Override
	public APIResponseDto getEmployeeById(Long id) {
		
		Employee employee = employeeRepository.findById(id).get();
		
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
//				DepartmentDto.class);
//		DepartmentDto deptDto = responseEntity.getBody();
		
		DepartmentDto deptDto = webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
				.retrieve().bodyToMono(DepartmentDto.class).block();
		
		OrganizationDto orgDto = webClient.get().uri("http://localhost:8084/api/organizations/"+employee.getOrganizationCode())
				.retrieve().bodyToMono(OrganizationDto.class).block();
		
//		DepartmentDto deptDto = feignClient.getDepartmentByCode(employee.getDepartmentCode());
		
		EmployeeDto edto = mapper.mapToEmployeeDto(employee);
		
		APIResponseDto apiresponse = new APIResponseDto();
		apiresponse.setDeptDto(deptDto);
		apiresponse.setEmployeeDto(edto);
		apiresponse.setOrganizationDto(orgDto);
		
		return apiresponse;
	}

}
