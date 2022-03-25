package com.unilever.request.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String materialRegister(String name, String unName, int ucxCod, float unPerBox, float unTotal, String cod) {
		UcxEntity ucxEntity = ucxRep.findByUcxId(ucxCod);
		
		MaterialEntity material = new MaterialEntity(ucxEntity, name, unName, String.valueOf(ucxCod), unPerBox, unTotal, cod);
		
		materialRep.save(material);
		materialRep.flush();
		
		return "material-register";
	}

}
