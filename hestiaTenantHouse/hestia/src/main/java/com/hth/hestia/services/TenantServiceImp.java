package com.hth.hestia.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.hth.hestia.dao.TenantRepository;
import com.hth.hestia.models.Tenant;

public class TenantServiceImp implements TenantService {
	
	
	private TenantRepository tenantRepo;
	
	@Autowired
	public TenantServiceImp (TenantRepository tenantRepo) {
		this.tenantRepo = tenantRepo;
	}



	@Override
	public Tenant getTenantByNameAndSurname(String name, String surname) {
		Tenant result = tenantRepo.findByNameAndSurname(name, surname).orElseThrow( );
		return result;
	}

	@Override
	public Tenant addTenant(Tenant tenant) throws Exception {
		
		if (tenantRepo.findByPersonnumber(tenant.getPersonnumber()).isEmpty()) {
			tenantRepo.save(tenant);
		} else {
			throw new  Exception();
		}
		return tenant;		
		
		
	}

}
