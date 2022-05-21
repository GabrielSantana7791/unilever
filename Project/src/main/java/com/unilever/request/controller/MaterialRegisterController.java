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
			login.check(httpSession);

			List<UcxEntity> ucxList = ucxRep.findAll();

			model.addAttribute("ucxList", ucxList);

			return "material-register";
		} catch (Exception e) {
			return "redirect:/login";
		}


	}

	@PostMapping(value= "/material-register")
	public String materialRegister(HttpSession httpSession, Model model, String name, String unName, int ucxCod,
			@RequestParam(defaultValue = "0") float unPerBox,
			float unTotal, @RequestParam(defaultValue = "0")  float weightToProduceOne,
			String cod, @RequestParam(defaultValue = "0") Boolean box,@RequestParam(defaultValue = "0") Boolean multiple) {

		try {
			login.check(httpSession);
		} catch (Exception e) {
			return "redirect:/login";
		} 

		if(unPerBox == 0) {
			unPerBox = unTotal;
		}

		if(materialRep.findByCod(cod) == null) {
			UcxEntity ucxEntity = ucxRep.findByUcxId(ucxCod);

			MaterialEntity material = new MaterialEntity(ucxEntity, name, unName, cod, unPerBox, unTotal, 
					weightToProduceOne, box, multiple);

			materialRep.save(material);
			materialRep.flush();

			Message message = new Message();
			message.setType("success");
			message.setMsg("Material cadastrado com sucesso");
			
			List<UcxEntity> ucxList = ucxRep.findAll();
			
			model.addAttribute("ucxList", ucxList);
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
