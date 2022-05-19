package com.unilever.request.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class UcxEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="_id")
	private int id;
	
	private int ucxId;
	
	private String name;
	private float unPerBox;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="_id")
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

	public float getUnPerBox() {
		return unPerBox;
	}

	public void setUnPerBox(float unPerBox) {
		this.unPerBox = unPerBox;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
