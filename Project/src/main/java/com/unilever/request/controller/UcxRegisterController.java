package com.unilever.request.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unilever.request.entity.UcxEntity;
import com.unilever.request.entity.UserEntity;
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
			UserEntity user = (UserEntity) httpSession.getAttribute("user");
			user = login.login(user);

			return "ucx-register";
		} catch (Exception e) {
			return "redirect:/login";
		}


	}

	@PostMapping(value= "/ucx-register")
	public String ucxRegister(HttpSession httpSession, int ucxCod, String name, int unPerBox, Model model) {

		try {
			UserEntity user = (UserEntity) httpSession.getAttribute("user");
			login.login(user);
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

			Message message = new Message();
			message.setType("success");
			message.setMsg("SKU cadastrado com sucesso");

			model.addAttribute("message", message);

			return "ucx-register";
		}
		
		Message message = new Message();
		message.setType("error");
		message.setMsg("Erro: SKU já cadastrado no banco de dados");

		model.addAttribute("message", message);

		return "ucx-register";


	}



}
