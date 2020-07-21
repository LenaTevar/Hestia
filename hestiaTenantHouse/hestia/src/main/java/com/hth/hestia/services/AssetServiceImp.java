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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asset getAssetByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asset addAsset(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asset updateAsset(Asset asset, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAsset(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Asset> getAssetByType(String type) {
		AssetTypeEnum selectedType = AssetTypeEnum.valueOf(type);
		System.out.println("SERVICE " + selectedType);
		List<Asset> result = assetRepo.findAll().stream().filter(asset -> asset.getType().equals(selectedType)).collect(Collectors.toList());
		return result;
		
	}
	
	
}
