package com.hth.hestia;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hth.hestia.dao.AssetRepository;
import com.hth.hestia.dao.TenantRepository;
import com.hth.hestia.models.Asset;
import com.hth.hestia.models.AssetTypeEnum;
import com.hth.hestia.models.Tenant; 

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DBLoader {
	@Bean
	CommandLineRunner initDB(TenantRepository tenantRepo,
			AssetRepository assetRepo) {
		return args -> {
			addTenants(tenantRepo);
			addAssets(assetRepo);
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
	
	private void addAssets(AssetRepository assetRepo) { 
		Asset A = new Asset("Avägen 1", AssetTypeEnum.HOUSE);
		Asset B = new Asset("Bvägen 1", AssetTypeEnum.HOUSE);		
		
		Asset C = new Asset("Cvägen 1",AssetTypeEnum.STUDENT);
		Asset D = new Asset("Dvägen 1",AssetTypeEnum.STUDENT);
		
		Asset E = new Asset("Evägen 1", AssetTypeEnum.SENIOR);		
		Asset F = new Asset("Fvägen 1", AssetTypeEnum.SENIOR);
		
		Asset G = new Asset("Gvägen 1", AssetTypeEnum.PARKING);
		Asset H = new Asset("Havägen 1", AssetTypeEnum.PARKING);
		
		Asset[] listAssets = {A, B, C, D, E, F, G, H};
		assetRepo.saveAll(Arrays.asList(listAssets));
		
	}

}
