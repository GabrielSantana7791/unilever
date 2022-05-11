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
import com.unilever.request.entity.UserEntity;
import com.unilever.request.etc.Login;
import com.unilever.request.etc.Message;
import com.unilever.request.repository.MaterialRepository;
import com.unilever.request.repository.UcxRepository;

@Controller
public class MaterialRegisterController {

	@Autowired
	private MaterialRepository materialRep;

	@Autowired
	private UcxRepository ucxRep;

	@Autowired
	private Login login;

	@GetMapping(value= "/material-register")
	public String materialRegister(Model model, HttpSession httpSession) {
		try {
			UserEntity user = (UserEntity) httpSession.getAttribute("user");
			user = login.login(user);

			List<UcxEntity> ucxList = ucxRep.findAll();

			model.addAttribute("ucxList", ucxList);

			return "material-register";
		} catch (Exception e) {
			return "redirect:/login";
		}


	}

	@PostMapping(value= "/material-register")
	public String materialRegister(HttpSession httpSession, Model model, String name, String unName, int ucxCod,  @RequestParam(defaultValue = "0") float unPerBox,
			float unTotal, @RequestParam(defaultValue = "0")  float weightToProduceOne, String cod, @RequestParam(defaultValue = "0") Boolean box,@RequestParam(defaultValue = "0") Boolean multiple) {

		try {
			UserEntity user = (UserEntity) httpSession.getAttribute("user");
			login.login(user);
		} catch (Exception e) {
			return "redirect:/login";
		} 

		if(unPerBox == 0) {
			unPerBox = unTotal;
		}

		if(materialRep.findByCod(cod).isEmpty() == true) {
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

			Message message = new Message();
			message.setType("success");
			message.setMsg("Material cadastrado com sucesso");

			model.addAttribute("message", message);

			return "material-register";
		}
		
		Message message = new Message();
		message.setType("error");
		message.setMsg("Erro: Código do material já cadastrado no banco de dados");

		model.addAttribute("message", message);

		List<UcxEntity> ucxList = ucxRep.findAll();

		model.addAttribute("ucxList", ucxList);

		return "material-register";
	}

}
