package com.unilever.request.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@JoinColumn(name="ucx_id")
	private UcxEntity ucxEntity;

	private String name, unName, cod;
	private float unPerBox, unTotal, weightToProduceOne;
	private Boolean box, multiple;

	private void init(UcxEntity ucxEntity, String name, String unName, String ucxCod, float unTotal, String cod, Boolean multiple){
		this.name = name;
		this.unName = unName;
		this.cod = cod;
		this.unTotal = unTotal;
		this.ucxEntity = ucxEntity;
		this.multiple = multiple;
	}

	//Without box
	public MaterialEntity(UcxEntity ucxEntity, String name, String unName, String ucxCod, float unTotal, String cod  ) {
		init(ucxEntity, cod, cod, cod, unTotal, cod, multiple);
	}

	//With box
	public MaterialEntity(UcxEntity ucxEntity, String name, String unName, String ucxCod, float unTotal, float unPerBox, String cod, Boolean box) {
		init(ucxEntity, cod, cod, cod, unTotal, cod, multiple);
		this.unPerBox = unPerBox;
		this.box = box;
	}
	
	//Bob
		public MaterialEntity(UcxEntity ucxEntity, String name, String unName, String ucxCod, float unTotal, float unPerBox, float weightToProduceOne, String cod, Boolean multiple) {
			init(ucxEntity, cod, cod, cod, unTotal, cod, multiple);
			this.unPerBox = unPerBox;
			this.weightToProduceOne = weightToProduceOne;
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
