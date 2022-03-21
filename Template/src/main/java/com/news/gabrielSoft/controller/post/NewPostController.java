package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.classes.Page;
import com.news.gabrielSoft.classes.Post;
import com.news.gabrielSoft.classes.Session;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class NewPostController extends Page{
	@Autowired
	public Session session;
	
	@Autowired
	public Post post;

	@GetMapping(value= "/novo-post")
	public String newPage(Model model, HttpSession httpSession) {
		try {
			title = "Add new post";
			pageFile = "newPost";
			pageInitializer(model, httpSession);
			
			return "base";
		} catch (Exception e) {
			return "redirect:/login";
		}
	}

	@PostMapping(value= "/addPost")
	public String addPost(PostIndexEntity postIndex, HttpSession httpSession, Model model) {
		try{
			session.userTestCredencial(httpSession, USER_ADMIN_LEVEL.admin);
			
			post.addPost(postIndex);
			
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "newPost");
			model.addAttribute(MODEL_ATTRIBUTES.message.toString(), "Postado com sucesso");
			return "base";
		}catch(Exception e) {
			return "redirect:/login";
		}
	}

	@GetMapping(value= "/addPost")
	public String addPost() {
		return "redirect:/";
	}
}
