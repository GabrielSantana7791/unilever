package com.unilever.request.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unilever.request.etc.Material;
import com.unilever.request.etc.MaterialCalculator;
import com.unilever.request.etc.MaterialCalculatorResults;

@RestController
public class manualController {
	@Autowired
	MaterialCalculator calculator;
	
	@GetMapping(value= "/")
	public String AboutMe() {
		 Material tampaSerac = new Material("tampa(s) 250g light Serac", "KG", "666", "777", 3000, 9000);
		//(String name, String unName, float cod, float ucxCod, float unPerBox, float unTotal
		 
		 MaterialCalculatorResults resultado = calculator.materialPerTurn(tampaSerac, 20000);
		 
		
		return resultado.toString();
	}

}
