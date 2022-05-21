package com.unilever.request.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unilever.request.entity.MaterialEntity;
import com.unilever.request.entity.UcxEntity;
import com.unilever.request.etc.Login;
import com.unilever.request.etc.Message;
import com.unilever.request.repository.MaterialRepository;
import com.unilever.request.repository.UcxRepository;

@Controller
public class MaterialEditController {
	@Autowired
	private MaterialRepository materialRep;

	@Autowired
	private UcxRepository ucxRep;

	@Autowired
	private Login login;

	@GetMapping(value= "/material-edit")
	public String materialEditGet(HttpSession httpSession, Model model, @RequestParam(required=true,defaultValue="-1") String materialCod) {
		try {
			login.check(httpSession);
		} catch (Exception e) {
			return "redirect:/login";
		}

		MaterialEntity materialEntity = materialRep.findByCod(materialCod);

		if(materialEntity == null && !materialCod.equals("-1")) {
			Message message = new Message();
			message.setMsg("Material não encontrado");
			message.setType("error");
			model.addAttribute("message", message);

			return "material-edit";
		}

		List<UcxEntity> ucxList = ucxRep.findAll();

		model.addAttribute("ucxList", ucxList);
		model.addAttribute("materialEntity", materialEntity);

		return "material-edit";
	}

	@PostMapping(value= "/material-edit")
	public String materilEditPost(HttpSession httpSession, Model model, String name, String unName, int ucxCod,
			@RequestParam(defaultValue = "0") float unPerBox,
			float unTotal, @RequestParam(defaultValue = "0")  float weightToProduceOne,
			String cod, @RequestParam(defaultValue = "0") Boolean box,@RequestParam(defaultValue = "0") Boolean multiple, String oldMaterialCod){

		try {
			login.check(httpSession);
		} catch (Exception e) {
			return "redirect:/login";
		}

		Message message = new Message();
		MaterialEntity material = materialRep.findByCod(oldMaterialCod);

		if(material !=null) {
			material.setAll(ucxRep.findByUcxId(ucxCod), name, unName, cod, unPerBox, unTotal, 
					weightToProduceOne, box, multiple);
			material.setId(material.getId());

			message.setType("success");
			message.setMsg("Material editado com sucesso");

			materialRep.flush();
			
			List<UcxEntity> ucxList = ucxRep.findAll();

			model.addAttribute("ucxList", ucxList);
			model.addAttribute("materialEntity", material);
			model.addAttribute("message", message);

			return "material-edit";
		}

		message.setMsg("Erro ao editar");
		message.setType("Error");

		model.addAttribute("message", message);

		return "material-edit";

	}

}
