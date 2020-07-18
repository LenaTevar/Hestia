package com.hth.hestia.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hth.hestia.models.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
	Optional<Tenant> findByPersonnumber(String personnumber);
	Optional<Tenant> findByNameAndSurname(String name, String surname);
}
