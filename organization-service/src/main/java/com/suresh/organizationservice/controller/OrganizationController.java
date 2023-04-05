package com.suresh.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.organizationservice.dto.OrganizationDto;
import com.suresh.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {
	
	private OrganizationService organizationService;
	
	@PostMapping
	public ResponseEntity<OrganizationDto> save(@RequestBody OrganizationDto orgDto)
	{
		return new ResponseEntity<>(organizationService.save(orgDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{organizationCode}")
	public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String organizationCode)
	{
		return new ResponseEntity<>(organizationService.getOrganizationByCode(organizationCode), HttpStatus.OK);
	}

}
