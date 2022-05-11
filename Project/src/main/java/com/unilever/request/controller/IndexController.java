package com.unilever.request.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value= "/")
	public String index(Model model, HttpSession session) {
		return "index";
	}
	
	@GetMapping(value= "/index")
	public String indexEmpty() {
		
		return "index";
	}
}
