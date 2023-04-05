package com.suresh.organizationservice.service;

import com.suresh.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
	
	OrganizationDto save(OrganizationDto orgDto);
	
	OrganizationDto getOrganizationByCode(String organizationCode);

}
