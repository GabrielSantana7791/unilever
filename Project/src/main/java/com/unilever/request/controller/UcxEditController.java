package com.unilever.request.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unilever.request.entity.UcxEntity;
import com.unilever.request.etc.Message;
import com.unilever.request.repository.UcxRepository;

@Controller
public class UcxEditController {
	
	@Autowired
	private UcxRepository ucxRep;
	
	@GetMapping(value= "/ucx-edit")
	public String edit(Model model, @RequestParam(required=true,defaultValue="-1") int ucxCod) {
		UcxEntity ucxEntity = ucxRep.findByUcxId(ucxCod);
	
		if(ucxEntity == null && ucxCod != -1) {
			Message message = new Message();
			message.setMsg("Código SKU não encontrado");
			message.setType("error");
			model.addAttribute("message", message);
			
			return "ucx-edit";
		}
		
		model.addAttribute("ucxEntity", ucxEntity);
		
		return "ucx-edit";
	}
	
	@PostMapping(value= "/ucx-edit")
	public String editPost(int oldUcxCod, UcxEntity newUcx, Model model) {
		UcxEntity oldUcxEntity = ucxRep.findByUcxId(oldUcxCod);
		UcxEntity newUcxCheck = ucxRep.findByUcxId(newUcx.getUcxId());
		
		Message message = new Message();
		
		if(oldUcxEntity == null) {
			message.setMsg("SKU não encontrado");
			message.setType("error");
			model.addAttribute("message", message);
			
			return "ucx-edit";
			
		} if (newUcxCheck != null && newUcxCheck.getUcxId() != oldUcxEntity.getUcxId()) {
			message.setMsg("SkU já está sendo utilizado");
			message.setType("error");
			model.addAttribute("message", message);
			
			return "ucx-edit";
		}
		
		oldUcxEntity.setName(newUcx.getName());
		oldUcxEntity.setUcxId(newUcx.getUcxId());
		oldUcxEntity.setUnPerBox(newUcx.getUnPerBox());
		
		ucxRep.flush();
		
		message.setMsg("SKU alterado com sucesso");
		message.setType("success");
		model.addAttribute("message", message);
		
		return "ucx-edit";
	}
	
	@PostMapping(value= "ucx-delete")
	public String deleteUcx(int ucxCod, Model model) {
		UcxEntity ucxEntity = ucxRep.findByUcxId(ucxCod);
		Message message = new Message();
		
		if(ucxEntity == null) {
			message.setMsg("SKU não encontrado ou já foi deletado anteriormente");
			message.setType("error");
			model.addAttribute("message", message);
			
			return "ucx-edit";
			
		}
		
		UcxEntity ucxToDelete = ucxRep.findByUcxId(ucxCod);
		ucxRep.deleteById(ucxToDelete.getId());
		ucxRep.flush();
		
		message.setMsg("Deletado com sucesso");
		message.setType("success");
		model.addAttribute("message", message);
		
		return "ucx-edit";
	}
	
	@GetMapping(value= "ucx-delete")
	public String deleteUcx() {
		return "redirect:/ucx-edit";
	}

}
