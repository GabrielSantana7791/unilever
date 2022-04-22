package com.unilever.request.etc;

import com.unilever.request.entity.MaterialEntity;

public class MaterialCalculatorResults {
	private float needMaterialUn, needUn, needBox, unBoxRest, unTotalRest, demand, unTotal, unBox;
	private Boolean box;

	private String name, unName, cod;
	private int ucxCod;
	
	public MaterialCalculatorResults(MaterialEntity material, float needMaterialUn, float needUn, float needBox, float unBoxRest, float unTotalRest, float demand){
		this.needMaterialUn = needMaterialUn;
		this.needUn = needUn;
		this.needBox = needBox;
		this.unBoxRest = unBoxRest;
		this.setDemand(demand);
		this.setUnTotalRest(unTotalRest);
		
		this.name = material.getName();
		this.unName = material.getUnName();
		this.ucxCod = material.getUcxCod();
		this.cod = material.getCod();
		this.unTotal = material.getUnTotal();
		this.box = material.getBox();
		
	}

	public float getNeedMaterialUn() {
		return needMaterialUn;
	}

	public void setNeedMaterialUn(float needMaterialUn) {
		this.needMaterialUn = needMaterialUn;
	}

	public float getNeedUn() {
		return needUn;
	}

	public void setNeedUn(float needUn) {
		this.needUn = needUn;
	}

	public float getNeedBox() {
		return needBox;
	}

	public void setNeedBox(float needBox) {
		this.needBox = needBox;
	}

	public float getUnBoxRest() {
		return unBoxRest;
	}

	public void setUnBoxRest(float unBoxRest) {
		this.unBoxRest = unBoxRest;
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

	public int getUcxCod() {
		return ucxCod;
	}

	public void setUcxCod(int ucxCod) {
		this.ucxCod = ucxCod;
	}

	public float getDemand() {
		return demand;
	}

	public void setDemand(float demand) {
		this.demand = demand;
	}

	public float getUnTotal() {
		return unTotal;
	}

	public void setUnTotal(float unTotal) {
		this.unTotal = unTotal;
	}

	public float getUnTotalRest() {
		return unTotalRest;
	}

	public void setUnTotalRest(float unTotalRest) {
		this.unTotalRest = unTotalRest;
	}
	
	public float getUnBox() {
		return unBox;
	}

	public void setUnBox(float unBox) {
		this.unBox = unBox;
	}

	public Boolean getBox() {
		return box;
	}

	public void setBox(Boolean box) {
		this.box = box;
	}

}
