package com.unilever.request.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MaterialEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name="_id")
	private UcxEntity ucxEntity;

	private String name, unName, cod;
	private float unPerBox, unTotal, weightToProduceOne;
	private Boolean box, multiple;

	public MaterialEntity(){

	}
	
	@Override
	public String toString() {
		return "MaterialEntity [id=" + id + ", ucxEntity=" + ucxEntity + ", name=" + name + ", unName=" + unName
				+ ", cod=" + cod + ", unPerBox=" + unPerBox + ", unTotal=" + unTotal + ", weightToProduceOne="
				+ weightToProduceOne + ", box=" + box + ", multiple=" + multiple + "]";
	}

	public MaterialEntity(UcxEntity ucxEntity, String name, String unName, String cod, float unPerBox, float unTotal,
			float weightToProduceOne, Boolean box, Boolean multiple){
		
		this.ucxEntity = ucxEntity;
		this.name = name;
		this.unName = unName;
		this.cod = cod;
		this.unPerBox = unPerBox;
		this.unTotal = unTotal;
		this.weightToProduceOne = weightToProduceOne;
		this.box = box;
		this.multiple = multiple;
	}
	
	public void setAll(UcxEntity ucxEntity, String name, String unName, String cod, float unPerBox, float unTotal,
			float weightToProduceOne, Boolean box, Boolean multiple){
		
		this.ucxEntity = ucxEntity;
		this.name = name;
		this.unName = unName;
		this.cod = cod;
		this.unPerBox = unPerBox;
		this.unTotal = unTotal;
		this.weightToProduceOne = weightToProduceOne;
		this.box = box;
		this.multiple = multiple;
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

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	public float getWeightToProduceOne() {
		return weightToProduceOne;
	}

	public void setWeightToProduceOne(float weightToProduceOne) {
		this.weightToProduceOne = weightToProduceOne;
	}


	public Boolean getBox() {
		return box;
	}

	public void setBox(Boolean box) {
		this.box = box;
	}
}
