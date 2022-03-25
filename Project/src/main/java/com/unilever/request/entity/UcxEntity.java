package com.unilever.request.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class UcxEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ucxId;
	
	String name;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="ucx_id")
	private List<MaterialEntity> materialEntity;

	

	public int getUcxId() {
		return ucxId;
	}

	public void setUcxId(int ucxId) {
		this.ucxId = ucxId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MaterialEntity> getMaterialEntity() {
		return materialEntity;
	}

	public void setMaterialEntity(List<MaterialEntity> materialEntity) {
		this.materialEntity = materialEntity;
	}
	
	

}
