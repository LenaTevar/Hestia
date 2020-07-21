package com.hth.hestia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hth.hestia.dao.TenantRepository;
import com.hth.hestia.models.Tenant;
@Service
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
	
	public void deleteTenantById(long id) {
		tenantRepo.delete(tenantRepo.findById(id).get());
	}
	
	@Scheduled(fixedRate = 5000L)
	public void addOnePointToAllTenants() {
		List <Tenant> tenants = tenantRepo.findAll();
		tenants.forEach(t->t.addOneDayPoint());
		tenantRepo.saveAll(tenants);
		System.out.println("ADDING POINTS TO TENANTS");
		System.out.println(tenantRepo.findAll());
		 
	}



	@Override
	public List<Tenant> getAllTenants() {
		return tenantRepo.findAll();
	}

}
