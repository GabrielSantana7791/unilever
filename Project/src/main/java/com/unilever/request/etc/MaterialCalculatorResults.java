package com.unilever.request.etc;

import com.unilever.request.entity.MaterialEntity;

public class MaterialCalculatorResults {
	private float needMaterialUn, needUn, needBox, unBoxRest, unTotalRest, demand;
	private MaterialEntity material;
	private String name, unName, cod, ucxCod;
	
	MaterialCalculatorResults(MaterialEntity material, float needMaterialUn, float needUn, float needBox, float unBoxRest, float unTotalRest, float demand){
		this.needMaterialUn = needMaterialUn;
		this.needUn = needUn;
		this.needBox = needBox;
		this.unBoxRest = unBoxRest;
		this.material = material;
		this.demand = demand;
		this.unTotalRest = unTotalRest;
		
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
		return material.getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnName() {
		return material.getUnName();
	}

	public void setUnName(String unName) {
		this.unName = unName;
	}

	public String getCod() {
		return material.getCod();
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public int getUcxCod() {
		return material.getUcxEntity().getUcxId();
	}

	public void setUcxCod(String ucxCod) {
		this.ucxCod = ucxCod;
	}

	@Override
	public String toString() {
		return "Existe uma demanda de: " + demand + " " + material.getName() + " Será necessário: " + needMaterialUn + " Pallets" + " ou " +
	needBox + " caixas...." + "Sobrará: " + unBoxRest + " caixas ou " + unTotalRest + " unidades." + " O código do material é: " + material.getCod() +
	" e o UCX é: " + material.getUcxEntity().getUcxId();
//		return "MaterialCalculatorResults [needMaterialUn=" + needMaterialUn + ", needUn=" + needUn + ", needBox="
//				+ needBox + ", unBoxRest=" + unBoxRest + "]";
	}
	
	

}
