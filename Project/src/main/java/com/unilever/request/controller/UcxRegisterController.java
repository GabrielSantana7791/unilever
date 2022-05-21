package com.unilever.request.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unilever.request.entity.UcxEntity;
import com.unilever.request.etc.Login;
import com.unilever.request.etc.Message;
import com.unilever.request.repository.UcxRepository;

@Controller
public class UcxRegisterController {

	@Autowired
	private UcxRepository ucxRep;

	@Autowired
	private Login login;

	@GetMapping(value= "/ucx-register")
	public String ucxRegister(HttpSession httpSession) {
		try {
			login.check(httpSession);

			return "ucx-register";
		} catch (Exception e) {
			return "redirect:/login";
		}


	}

	@PostMapping(value= "/ucx-register")
	public String ucxRegister(HttpSession httpSession, int ucxCod, String name, int unPerBox, Model model) {

		try {
			login.check(httpSession);
		} catch (Exception e) {
			return "redirect:/login";
		} 

		if(ucxRep.findByUcxId(ucxCod) == null) {
			UcxEntity ucx = new UcxEntity();
			ucx.setUcxId(ucxCod);
			ucx.setName(name);
			ucx.setUnPerBox(unPerBox);

			ucxRep.save(ucx);
			ucxRep.flush();

			Message message = new Message("success", "SKU cadastrado com sucesso");

			model.addAttribute("message", message);

			return "ucx-register";
		}
		
		Message message = new Message("error", "Erro: SKU já cadastrado no banco de dados");

		model.addAttribute("message", message);

		return "ucx-register";


	}



}
