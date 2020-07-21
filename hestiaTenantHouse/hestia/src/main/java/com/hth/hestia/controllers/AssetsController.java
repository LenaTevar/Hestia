package com.hth.hestia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hth.hestia.dao.AssetRepository;
import com.hth.hestia.models.Asset;
import com.hth.hestia.services.interfaces.AssetService;

@RestController
public class AssetsController {
	private final AssetRepository assetRepo;
	@Autowired
	private AssetService assetSvc;
	
	AssetsController(AssetRepository assetRepo){
		this.assetRepo = assetRepo;
	}
	
	@GetMapping("/assets")
	List<Asset> allAssets(){
		return this.assetSvc.getAllAssets();
	}
	
	@GetMapping("/assets/{type}")
	List<Asset> assetsByType(@PathVariable String type) {
		
		return this.assetSvc.getAssetByType(type);
	}
}
