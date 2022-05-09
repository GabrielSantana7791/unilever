package com.unilever.request.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unilever.request.entity.UcxEntity;
import com.unilever.request.etc.Message;
import com.unilever.request.repository.UcxRepository;

@Controller
public class UcxRegisterController {
	
	@Autowired
	private UcxRepository ucxRep;
	
	@GetMapping(value= "/ucx-register")
	public String ucxRegister() {
		
		return "ucx-register";
	}
	
	@PostMapping(value= "/ucx-register")
	public String ucxRegister(int ucxCod, String name, int unPerBox, Model model) {
		
		if(ucxRep.findByUcxId(ucxCod) == null) {
			UcxEntity ucx = new UcxEntity();
			ucx.setUcxId(ucxCod);
			ucx.setName(name);
			ucx.setUnPerBox(unPerBox);
			
			ucxRep.save(ucx);
			ucxRep.flush();
			
			Message message = new Message();
			message.setType("success");
			message.setMsg("SKU cadastrado com sucesso");
			
			model.addAttribute("message", message);
		}else {
			Message message = new Message();
			message.setType("error");
			message.setMsg("Erro: SKU já cadastrado no banco de dados");
			
			model.addAttribute("message", message);
		}
		
		
		return "ucx-register";
	}
	
	
	
}
