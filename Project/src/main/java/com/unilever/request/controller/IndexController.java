package com.unilever.request.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unilever.request.etc.Login;

@Controller
public class IndexController {

	@Autowired
	private Login login;

	@GetMapping(value= "/")
	public String index(Model model, HttpSession httpSession) {
		try {
			login.check(httpSession);
		} catch (Exception e) {
			httpSession.invalidate();
		}

		return "index";
	}

	@GetMapping(value= "/index")
	public String indexEmpty(Model model, HttpSession httpSession) {
		try {
			login.check(httpSession);
		} catch (Exception e) {
			httpSession.invalidate();
		}

		return "index";
	}
}
