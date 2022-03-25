package com.unilever.request.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.unilever.request.entity.MaterialEntity;
import com.unilever.request.entity.UcxEntity;
import com.unilever.request.etc.MaterialCalculator;
import com.unilever.request.etc.MaterialCalculatorResults;
import com.unilever.request.repository.MaterialRepository;
import com.unilever.request.repository.UcxRepository;

@Controller
public class ManualController {
	@Autowired
	MaterialCalculator calculator;
	
	@Autowired
	MaterialRepository materialRep;
	
	@Autowired
	UcxRepository ucxRep;
	
	@GetMapping(value= "/calculate")
	public String AboutMe(Model model, float typeNumber, String ucxCode) {	
		
		List<MaterialCalculatorResults> resultList = new ArrayList<>();		
		
		for (MaterialEntity materialEntity : materialRep.findByUcxEntity(ucxRep.findByUcxId(Integer.valueOf(ucxCode)))) {
			MaterialCalculatorResults result =  calculator.materialPerTurn(materialEntity, typeNumber);
			resultList.add(result);
		}
		
	 model.addAttribute("resultList", resultList);
		
	 return "resultadoManual";
	}
	
	@GetMapping(value= "/manual")
	public String tasd() {
		return "manual";
	}

}
