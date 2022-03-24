package com.unilever.request.etc;

import org.springframework.stereotype.Service;

@Service
public class MaterialCalculator {

	
	public MaterialCalculatorResults materialPerTurn(Material material, float toProduceMaterial) {
		float needMaterialUn = 0, needUn = 0, needBox = 0, unBoxRest = 0, unTotalRest = 0;
		
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
		
		MaterialCalculatorResults result = new MaterialCalculatorResults(material, needMaterialUn, needUn, needBox, unBoxRest, unTotalRest, toProduceMaterial);
		
		return result;
	}
	
	
	

}
