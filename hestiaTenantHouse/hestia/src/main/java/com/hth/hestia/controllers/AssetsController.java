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
	@GetMapping("/assets/id:{id}")
	Asset getAssetById(@PathVariable long id) {
		return assetSvc.getAssetById(id);
	}
	
	/**
	 * 
	 * @param asset
	 * {
        "id": 6,
        "address": "Bvägen 1",
        "type": "HOUSE"
    	}
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/assets")
	Asset addAsset(@RequestBody Asset asset) throws Exception {
		return assetSvc.addAsset(asset);
	}
	/**
	 * 
	 * @param asset
	 * {
        "id": 6,
        "address": "Bvägen 1",
        "type": "HOUSE"
    	}
	 * @param id
	 * @return
	 */
	@PutMapping("/assets/{id}")
	Asset updateAsset(@RequestBody Asset asset, @PathVariable long id) {
		return assetSvc.updateAsset(asset, id);
	}
	@DeleteMapping("/assets/{id}")
	void deleteAsset(@PathVariable long id) {
		assetSvc.deleteAsset(id); 
	}
}
