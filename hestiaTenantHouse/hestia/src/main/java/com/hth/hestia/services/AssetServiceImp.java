package com.hth.hestia.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hth.hestia.dao.AssetRepository;
import com.hth.hestia.models.Asset;
import com.hth.hestia.models.AssetTypeEnum;
import com.hth.hestia.services.interfaces.AssetService;

@Service
public class AssetServiceImp implements AssetService{
	private AssetRepository assetRepo;
	
	@Autowired
	public AssetServiceImp(AssetRepository assetRepo) {
		this.assetRepo = assetRepo;
	}

	@Override
	public List<Asset> getAllAssets() {
		return assetRepo.findAll();
	}

	@Override
	public Asset getAssetById(long id) {
		return assetRepo.findById(id).get();
	}

	@Override
	public Asset getAssetByAddress(String address) {
		return assetRepo.findByAddress(address).get();
	}

	@Override
	public Asset addAsset(Asset asset) throws Exception {
		if (assetRepo.findByAddress(asset.getAddress()).isEmpty()) {
			assetRepo.save(asset);
		} else {
			throw new Exception();
		}
		return asset;
	}

	@Override
	public Asset updateAsset(Asset updated, long id) {
		Asset current = assetRepo.findById(id).get();
		current.setAddress(updated.getAddress());
		current.setType(updated.getType());
		assetRepo.save(current);
		return current;
	}

	@Override
	public void deleteAsset(long id) {
		assetRepo.deleteById(id);
		
	}

	@Override
	public List<Asset> getAssetByType(String type) {
		AssetTypeEnum selectedType = AssetTypeEnum.valueOf(type);
		System.out.println("SERVICE " + selectedType);
		List<Asset> result = assetRepo.findAll().stream().filter(asset -> asset.getType().equals(selectedType)).collect(Collectors.toList());
		return result;
		
	}
	
	
}
