package com.unilever.request.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.unilever.request.etc.Machine;

@Entity
public class MaterialEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	
	
	private String name, unName, cod, ucxCod;
	private float unPerBox, unTotal;
	
	public MaterialEntity(String name, String unName, String cod, String ucxCod, float unPerBox, float unTotal){
		this.name = name;
		this.unName = unName;
		this.cod = cod;
		this.ucxCod = ucxCod;
		this.unPerBox = unPerBox;
		this.unTotal = unTotal;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnName() {
		return unName;
	}
	public void setUnName(String unName) {
		this.unName = unName;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getUcxCod() {
		return ucxCod;
	}
	public void setUcxCod(String ucxCod) {
		this.ucxCod = ucxCod;
	}
	public float getUnPerBox() {
		return unPerBox;
	}
	public void setUnPerBox(float unPerBox) {
		this.unPerBox = unPerBox;
	}
	public float getUnTotal() {
		return unTotal;
	}
	public void setUnTotal(float unTotal) {
		this.unTotal = unTotal;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
