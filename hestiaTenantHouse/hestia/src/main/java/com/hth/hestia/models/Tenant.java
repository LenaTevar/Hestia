package com.hth.hestia.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Tenants")
public class Tenant {

	@Id
	@GeneratedValue
	private long id;
	
	private String name; 
	private String surname;
	private String personnumber;
	
	Tenant(){}
	public Tenant(String name, String surname, String pn) {
		this.name = name;
		this.surname = surname;
		this.personnumber = pn;
	}
}
