package com.suresh.organizationservice.mapper;

import org.springframework.stereotype.Service;

import com.suresh.organizationservice.dto.OrganizationDto;
import com.suresh.organizationservice.entity.Organization;

@Service
public class OrganizationMapper {
	
	public Organization  mapToOrganization(OrganizationDto orgDto)
	{
		Organization org = new Organization();
		org.setOrganizationCode(orgDto.getOrganizationCode());
		org.setCreatedDate(orgDto.getCreatedDate());
		org.setOrganizationDescription(orgDto.getOrganizationDescription());
		org.setOrganizationName(orgDto.getOrganizationName());
		
		return org;
	}
	
	public OrganizationDto mapToOrganizationDto(Organization org)
	{
		OrganizationDto orgDto = new OrganizationDto();
		
		orgDto.setCreatedDate(org.getCreatedDate());
		orgDto.setId(org.getId());
		orgDto.setOrganizationCode(org.getOrganizationCode());
		orgDto.setOrganizationDescription(org.getOrganizationDescription());
		orgDto.setOrganizationName(org.getOrganizationName());
		
		return orgDto;
	}

}
