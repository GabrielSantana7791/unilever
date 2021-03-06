package com.unilever.request.etc;

import org.springframework.stereotype.Service;

import com.unilever.request.entity.MaterialEntity;

@Service
public class MaterialCalculator {

	public MaterialCalculatorResults materialPerTurn(MaterialEntity material, float toProduceMaterial) {
		float needMaterialUn = 0, needUn = 0, needBox = 0, unBoxRest = 0, unTotalRest = 0;
		

		if(material.getMultiple() == true) {
			toProduceMaterial *= material.getUcxEntity().getUnPerBox();			
		}
		
		switch (material.getUnName()) {
		case "un":

			for(float i = 0; i < toProduceMaterial;) {

				needMaterialUn ++;
				i += material.getUnTotal();
				needUn = i;
				needBox = needUn / material.getUnPerBox();

			}

			if(needUn > toProduceMaterial && material.getBox() == true) {
				unBoxRest = (float) Math.ceil((needUn - toProduceMaterial) / material.getUnPerBox());
				unTotalRest = (float) Math.ceil(needUn - toProduceMaterial);
			}else if(needUn >= toProduceMaterial && material.getBox() == false){
				unTotalRest = (float) Math.ceil(needUn - toProduceMaterial);
				unBoxRest = (float) Math.ceil(unTotalRest);
				needBox = needUn;
			}

			MaterialCalculatorResults result = new MaterialCalculatorResults(material, needMaterialUn, needUn,
					needBox, unBoxRest, unTotalRest, toProduceMaterial);

			result.setUnBox((material.getUnTotal() / material.getUnPerBox()));

			return result;

		case "kg":
			float toProduceMaterialWeight = material.getWeightToProduceOne() * material.getUcxEntity().getUnPerBox() * toProduceMaterial;
			for(float i = 0; i < toProduceMaterialWeight;) {

				needMaterialUn ++;
				i += material.getUnTotal();
				needUn = i;

				needBox = (float) Math.ceil(needMaterialUn *(material.getUnTotal() / material.getUnPerBox()));

			}

			if(needUn > toProduceMaterial) {
				needUn = needMaterialUn * material.getUnTotal();
				unBoxRest = 0;
				unTotalRest = 0;

			}
			
			toProduceMaterial = toProduceMaterial * material.getUcxEntity().getUnPerBox() * material.getWeightToProduceOne();

			MaterialCalculatorResults result1 = new MaterialCalculatorResults(material, needMaterialUn, needUn, 
					needBox, unBoxRest, unTotalRest, toProduceMaterial);
			
			//adicionar unBox no metodo construtor!!!!!!!!!!!!!!!!!!!!!!!!kk
			result1.setUnBox((material.getUnTotal() / material.getUnPerBox()));

			return result1;

		default:
			return null;

		}
	}
}
