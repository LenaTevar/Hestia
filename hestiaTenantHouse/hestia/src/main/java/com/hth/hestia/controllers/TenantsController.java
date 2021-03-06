package com.hth.hestia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hth.hestia.dao.TenantRepository;
import com.hth.hestia.models.Tenant;
import com.hth.hestia.services.interfaces.TenantService;

@RestController
public class TenantsController {

	private final TenantRepository tenantRepo;
	@Autowired
	private TenantService tenantSvc;
	
	TenantsController(TenantRepository tenantRepo){
		this.tenantRepo = tenantRepo;
	}
	
	@GetMapping("/tenants")
	List<Tenant> allTenants(){
		return tenantSvc.getAllTenants();
	}
	@GetMapping("/tenants/{id}")
	Tenant getTenantById( @PathVariable long id) {
		return tenantSvc.getTenantById(id);
	}
	
	
	/**
	 * 
	 * @param n_tenant
	 * @return
	 * @throws Exception
	 * @apiNote 
	 * {
		    "name": "Zack",
		    "surname": "Zuchini",
		    "idnumber": "00009988-7777"
		}	
	 */
	@PostMapping("/tenants")
	Tenant addTenant(@RequestBody Tenant n_tenant) throws Exception {
		return tenantSvc.addTenant(n_tenant);
	}
	
	/**
	 * 
	 * @param n_tenant
	 * @param id
	 * @return
	 * @apiNote {
        "name": "Ana",
        "surname": "Anders",
        "identification": "11112233-4444",
        "created_at": "2020-07-21",
        "points": 10000
    }
	 */
	 @PutMapping("/tenants/{id}")
	 Tenant updateTenant(@RequestBody Tenant n_tenant, @PathVariable long id) {
		 return tenantSvc.updateTenant(n_tenant, id);
	 }
	 
	 @DeleteMapping("/tenants/{id}")
	 void deleteTenant(@PathVariable long id) {
		 tenantSvc.deleteTenant(id);
	 }
	
}
