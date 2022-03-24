package com.unilever.request.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.unilever.request.entity.MaterialEntity;
import com.unilever.request.etc.MaterialCalculator;
import com.unilever.request.etc.MaterialCalculatorResults;
import com.unilever.request.repository.MaterialRepository;

@Controller
public class manualController {
	@Autowired
	MaterialCalculator calculator;
	
	@Autowired
	MaterialRepository materialRep;
	
	@GetMapping(value= "/calculate")
	public String AboutMe(Model model, float typeNumber, String ucxCode) {
		MaterialEntity tampaSerac = new MaterialEntity("tampa(s) 250g light Serac", "KG", "6798981", "66678", 3000, 9000);
		MaterialEntity rotuloSerac = new MaterialEntity("rotulo(s) 250g light Serac", "KG", "6798246", "66678", 5000, 15000);
		
		MaterialEntity tampaP3 = new MaterialEntity("tampa(s) 500g light P3", "KG", "6798981", "66678", 3000, 9000);
		MaterialEntity rotuloP3 = new MaterialEntity("rotulo(s) 500g light P3", "KG", "6798246", "66678", 5000, 15000);
		//(String name, String unName, float cod, float ucxCod, float unPerBox, float unTotal
		
		 MaterialCalculatorResults resultado = null;
		 MaterialCalculatorResults resultado2 = null;
		
		switch (ucxCode) {
		case "66678":
			 resultado = calculator.materialPerTurn(tampaSerac, typeNumber);
			 resultado2 = calculator.materialPerTurn(rotuloSerac, typeNumber);
		
			break;
			
		case "66679":
			 resultado = calculator.materialPerTurn(tampaP3, typeNumber);
			 resultado2 = calculator.materialPerTurn(rotuloP3, typeNumber);
			 
			break;

		default:
			break;
		}
		 
		 
		 List<MaterialCalculatorResults> resultList = new ArrayList<>();
		 resultList.add(resultado);
		 resultList.add(resultado2);
		 
		 
		 model.addAttribute("resultList", resultList);
		 
		
		 return "resultadoManual";
	}
	
	@GetMapping(value= "/manual")
	public String tasd() {
		return "manual";
	}

}
