package com.unilever.request.entity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value= "/")
	public String a() {
		
		return "index";
	}
	
	@GetMapping(value= "/index")
	public String b() {
		
		return "index";
	}


}
