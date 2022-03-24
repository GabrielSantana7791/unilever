package com.unilever.request.etc;

public class Material {
	
	private String name, unName, cod, ucxCod;
	private float unPerBox, unTotal;
	
	public Material(String name, String unName, String cod, String ucxCod, float unPerBox, float unTotal){
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
	
	

}

/* unPerBox = unidade por caixa ou laminado */
