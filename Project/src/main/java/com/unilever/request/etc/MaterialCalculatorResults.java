package com.unilever.request.etc;

public class MaterialCalculatorResults {
	private float needMaterialUn, needUn, needBox, unBoxRest, unTotalRest, demand;
	private Material material;
	
	MaterialCalculatorResults(Material material, float needMaterialUn, float needUn, float needBox, float unBoxRest, float unTotalRest, float demand){
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

	@Override
	public String toString() {
		return "Existe uma demanda de: " + demand + " " + material.getName() + " Será necessário: " + needMaterialUn + " Pallets" + " ou " +
	needBox + " caixas...." + "Sobrará: " + unBoxRest + " caixas ou " + unTotalRest + " unidades." + " O código do material é: " + material.getCod() +
	" e o UCX é: " + material.getUcxCod();
//		return "MaterialCalculatorResults [needMaterialUn=" + needMaterialUn + ", needUn=" + needUn + ", needBox="
//				+ needBox + ", unBoxRest=" + unBoxRest + "]";
	}
	
	

}
