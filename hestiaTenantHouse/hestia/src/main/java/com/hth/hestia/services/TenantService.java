package com.hth.hestia.services;

import org.springframework.stereotype.Service;

import com.hth.hestia.models.Tenant;

@Service
public interface TenantService {

	Tenant getTenantByNameAndSurname(String name, String surname);
	Tenant addTenant(Tenant tenant) throws Exception;
}
