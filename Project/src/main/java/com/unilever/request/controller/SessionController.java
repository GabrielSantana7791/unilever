package com.unilever.request.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unilever.request.entity.UserEntity;
import com.unilever.request.etc.Login;
import com.unilever.request.etc.Message;

@Controller
public class SessionController {
	@Autowired
	private Login login;
	
	@GetMapping(value = "/end-session")
	public String desc(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping(value = "/login")
	public String login (Model model) {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(HttpSession httpSession, UserEntity user, Model model) {
		try {
			UserEntity validatedUser = login.login(user);
			
			httpSession.setAttribute("user", validatedUser);
			
			return "redirect:/";
			
		} catch (Exception e) {
			Message message = new Message();
			message.setType("error");
			message.setMsg("Usuário não encontrado ou senha inválida");
			
			model.addAttribute("message", message);
			return "login";
		}
		
		
	}

}
