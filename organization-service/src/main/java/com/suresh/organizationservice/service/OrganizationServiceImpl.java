package com.suresh.organizationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.organizationservice.dto.OrganizationDto;
import com.suresh.organizationservice.entity.Organization;
import com.suresh.organizationservice.mapper.OrganizationMapper;
import com.suresh.organizationservice.repository.OrganizationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{
	
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private OrganizationMapper mapper;

	@Override
	public OrganizationDto save(OrganizationDto orgDto) {
		
		Organization org = mapper.mapToOrganization(orgDto);
		
		Organization org2 = organizationRepository.save(org);
		
		return mapper.mapToOrganizationDto(org2);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {

		Organization org = organizationRepository.findByOrganizationCode(organizationCode);
		return mapper.mapToOrganizationDto(org);
	}

}
