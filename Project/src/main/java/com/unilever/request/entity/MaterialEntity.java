package com.unilever.request.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MaterialEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="ucx_id")
	private UcxEntity ucxEntity;
	
	private String name, unName, cod, ucxCod;
	private float unPerBox, unTotal;
	
	public MaterialEntity(UcxEntity ucxEntity, String name, String unName, String ucxCod, float unPerBox, float unTotal){
		this.name = name;
		this.unName = unName;
		this.cod = cod;
		this.unPerBox = unPerBox;
		this.unTotal = unTotal;
	}
	
	public MaterialEntity(){
		
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

	public UcxEntity getUcxEntity() {
		return ucxEntity;
	}

	public void setUcxEntity(UcxEntity ucxEntity) {
		this.ucxEntity = ucxEntity;
	}

	public int getUcxCod() {
		return ucxEntity.getUcxId();
	}

	public void setUcxCod(String ucxCod) {
		this.ucxCod = ucxCod;
	}

	

	
	
	
	

}
