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
import com.unilever.request.exceptions.EmptUserException;
import com.unilever.request.exceptions.InvalidUserException;

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
	public String login (Model model, HttpSession httpSession) {
		try {
			login.check(httpSession);
			return "redirect:/";
			
		} catch (InvalidUserException e) {
			httpSession.invalidate();
			
			return "login";
		}  catch (EmptUserException e) {
			httpSession.invalidate();
			
			return "login";
		}
		
	}
	
	@PostMapping(value = "/login")
	public String login(HttpSession httpSession, UserEntity userEntity, Model model) {
		try {
			login.login(httpSession, userEntity);
			return "redirect:/";
			
		} catch (InvalidUserException e) {
			Message message = new Message("error", "Usuário não encontrado ou senha inválida");
			
			model.addAttribute("message", message);
			
			return "login";
		} catch (NullPointerException e) {
			Message message = new Message("error", "Usuário não encontrado ou senha inválida");
			
			model.addAttribute("message", message);
			
			return "login";
		}
		
		
	}

}
