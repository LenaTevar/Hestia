package com.hth.hestia.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hth.hestia.models.Asset;
@Service
public interface AssetService {
	
	List<Asset> getAllAssets();
	List<Asset> getAssetByType(String type);
	Asset getAssetById(long id);
	Asset getAssetByAddress(String address);
	Asset addAsset(Asset asset) throws Exception;
	Asset updateAsset(Asset asset, long id);
	void deleteAsset(long id);

}
