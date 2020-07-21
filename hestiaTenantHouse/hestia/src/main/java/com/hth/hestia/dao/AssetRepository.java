package com.hth.hestia.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hth.hestia.models.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long>{
	Optional<Asset> findByAddress(String address);
	List<Asset> findByType(String type);

}
