package com.unilever.request.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unilever.request.entity.MaterialEntity;
import com.unilever.request.entity.UcxEntity;
import com.unilever.request.repository.MaterialRepository;
import com.unilever.request.repository.UcxRepository;

@Controller
public class MaterialRegisterController {
	
	@Autowired
	private MaterialRepository materialRep;
	
	@Autowired
	private UcxRepository ucxRep;
	
	@GetMapping(value= "/material-register")
	public String materialRegister(Model model) {
		
		List<UcxEntity> ucxList = ucxRep.findAll();
		
		model.addAttribute("ucxList", ucxList);
		
		return "material-register";
	}
	
	@PostMapping(value= "/material-register")
	public String materialRegister(String name, String unName, int ucxCod,  @RequestParam(defaultValue = "0") float unPerBox,
		float unTotal, @RequestParam(defaultValue = "0")  float weightToProduceOne, String cod, @RequestParam(defaultValue = "0") Boolean box,@RequestParam(defaultValue = "0") Boolean multiple) {
		
		if(unPerBox == 0) {
			unPerBox = unTotal;
		}
		
		UcxEntity ucxEntity = ucxRep.findByUcxId(ucxCod);
		
		MaterialEntity material = new MaterialEntity();
		material.setName(name);
		material.setUnName(unName);
		material.setCod(cod);
		material.setUcxEntity(ucxEntity);
		material.setUnPerBox(unPerBox);
		material.setUnTotal(unTotal);
		material.setMultiple(multiple);
		material.setBox(box);		
		material.setWeightToProduceOne(weightToProduceOne);
		
		materialRep.save(material);
		materialRep.flush();
		
		return "/index";
	}

}
