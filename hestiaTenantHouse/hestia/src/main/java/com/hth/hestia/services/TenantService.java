package com.hth.hestia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hth.hestia.models.Tenant;

@Service
public interface TenantService {

	List<Tenant> getAllTenants();
	Tenant getTenantByNameAndSurname(String name, String surname);
	Tenant addTenant(Tenant tenant) throws Exception; 
	Tenant updateTenant(Tenant tenant, long id);
	void deleteTenant(long id);
	
}
