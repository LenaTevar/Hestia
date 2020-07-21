package com.hth.hestia.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.hth.hestia.dao.TenantRepository;
import com.hth.hestia.models.Tenant;
import com.hth.hestia.services.interfaces.TenantService;

@SpringBootTest
public class TenantSvcTest { 
	
	
	TenantService svc;
	
	@Mock
	TenantRepository repo;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		svc = new TenantServiceImp(repo);

	}
	
	 @Test
	 public void testAddUser() throws Exception {
		 Tenant A = new Tenant("Claire", "Moon", "12345678-9012");
		 when(repo.save(A)).thenReturn(A);
		 
		 Tenant result = svc.addTenant(A);
		 assertEquals(A, result);
		 
		 // Test duplications 
		 when(repo.findByIdentification(A.getIdentification())).thenReturn(Optional.of(A));
		 assertThrows(Exception.class, () -> svc.addTenant(A));
		 
	 }
	 
	 @Test
	 public void getUserByNameAndSurnameTest() {
		 Tenant expected = new Tenant("Ana", "Banana", "11112233-4444"); 
		 
		 when(repo.findByNameAndSurname(expected.getName(), expected.getSurname()))
		 	.thenReturn(Optional.of(expected));
		 
		 Tenant result = svc.getTenantByNameAndSurname(expected.getName(), expected.getSurname());
		 assertEquals(expected, result);
	 }
	 
	 
	  
}
