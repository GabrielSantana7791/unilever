package com.unilever.request.etc;

import org.springframework.stereotype.Service;

import com.unilever.request.entity.MaterialEntity;

@Service
public class MaterialCalculator {

	
	public MaterialCalculatorResults materialPerTurn(MaterialEntity material, float toProduceMaterial) {
		float needMaterialUn = 0, needUn = 0, needBox = 0, unBoxRest = 0, unTotalRest = 0;
		
		if(material.getMultiple() == true) {
			toProduceMaterial *=  material.getUcxEntity().getUnPerBox();
		}
		
		for(float i = 0; i < toProduceMaterial;) {
			
			needMaterialUn ++;
			i += material.getUnTotal();
			needUn = i;
			needBox = needUn / material.getUnPerBox();
			
		}
		
		if(needUn > toProduceMaterial) {
			unBoxRest = (needUn - toProduceMaterial) / material.getUnPerBox();
			unTotalRest = needUn - toProduceMaterial;
		}
		
		if(material.getMultiple() == false) {
			unBoxRest = unTotalRest;
			needBox = 0;
		}
		
		MaterialCalculatorResults result = new MaterialCalculatorResults(material, needMaterialUn, needUn, needBox, unBoxRest, unTotalRest, toProduceMaterial);
		
		return result;
	}
	
	
	

}
