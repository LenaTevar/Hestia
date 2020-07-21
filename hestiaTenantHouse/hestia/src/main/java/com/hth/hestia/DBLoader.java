package com.hth.hestia;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hth.hestia.dao.TenantRepository;
import com.hth.hestia.models.Tenant; 

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DBLoader {
	@Bean
	CommandLineRunner initDB(TenantRepository tenantRepo) {
		return args -> {
			addTenants(tenantRepo);
		};
	}
	
	private void addTenants(TenantRepository tenantRepo) {
		Tenant A = new Tenant("Ana", "Anders", "11112233-4444");
		Tenant B = new Tenant("Bob", "Baker", "55556677-8888");
		Tenant C = new Tenant("Claire", "Conrad", "99990011-2222");
		Tenant D = new Tenant("Dennis", "Dickens", "11112233-1111");
		Tenant[] listTenants = {A, B, C, D};
		tenantRepo.saveAll(Arrays.asList(listTenants));
		
		
		
	}

}
