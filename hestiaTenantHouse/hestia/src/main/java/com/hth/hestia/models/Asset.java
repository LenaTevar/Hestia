package com.hth.hestia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Assets")
public class Asset {

	@Id
	@GeneratedValue
	@Column
	private long id;	
	@Column
	private String address;
	@Column
	private AssetTypeEnum type;
	
	Asset(){}
	public Asset (String address, String type) {
		this.setAddress(address);
		this.setType(AssetTypeEnum.valueOf(type));
	}
	public Asset(String address, AssetTypeEnum type) {
		this.setAddress(address);
		this.setType(type);
	}
	
	
}
