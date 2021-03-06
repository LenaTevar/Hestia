package com.hth.hestia.models;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TenantTest {

	 @Test
	 public void testTenantToString() {
		 Tenant t = new Tenant();
		
		 t.setName("Ana");
		 t.setSurname("Aguirre");
		 t.setIdentification("11112233-4444");
		 System.out.println(t);
		 assertNotNull(t);
		 assertNotNull(t.getId());
	 }
}
