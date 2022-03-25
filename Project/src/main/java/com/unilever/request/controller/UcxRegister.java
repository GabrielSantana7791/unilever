package com.unilever.request.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unilever.request.entity.UcxEntity;
import com.unilever.request.repository.UcxRepository;

@Controller
public class UcxRegister {
	
	@Autowired
	private UcxRepository ucxRep;
	
	@GetMapping(value= "/ucx-register")
	public String register() {
		
		return "ucx-register";
	}
	
	@PostMapping(value= "/ucx-register")
	public String register(int ucxCod, String name) {
		UcxEntity ucx = new UcxEntity();
		ucx.setUcxId(ucxCod);
		ucx.setName(name);
		
		ucxRep.save(ucx);
		ucxRep.flush();
		
		return "ucx-register";
	}
	
	
}
