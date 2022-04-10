package com.unilever.request.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unilever.request.entity.MaterialEntity;
import com.unilever.request.etc.MaterialCalculatorResults;
import com.unilever.request.repository.Animal;
import com.unilever.request.repository.MaterialRepository;
import com.unilever.request.repository.Pessoa;

@Controller
public class UcxTeste {
	
	@Autowired
	private MaterialRepository materialRep;
	
	@GetMapping(value= "/abc")
	public String register(Model model) {
		
		MaterialCalculatorResults matteste = new MaterialCalculatorResults(materialRep.findById(1), 0, 0, 0, 0, 0, 0);
		Animal animal = new Animal();
	//	pessoa.setIdade("2");
		model.addAttribute("material", matteste);
		
		return "base";
	}

}
