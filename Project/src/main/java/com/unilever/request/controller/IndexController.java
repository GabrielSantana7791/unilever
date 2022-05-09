package com.unilever.request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value= "/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping(value= "/index")
	public String indexEmpty() {
		
		return "index";
	}
}
