package com.hth.hestia.models;

import java.time.LocalDate; 

import javax.persistence.Column;
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
	@Column
	private long id;
	@Column
	private String name; 
	@Column
	private String surname;
	@Column
	private String personnumber;	
	@Column(name = "created_at")
	private LocalDate created_at;
	@Column
	private int points;

	Tenant(){
		this.created_at = LocalDate.now();
	}
	
	public Tenant(String name, String surname, String pn) {
		this.name = name;
		this.surname = surname;
		this.personnumber = pn;
		this.created_at = LocalDate.now();
	}
	public void addOneDayPoint() {
		this.points++;
	}
}
