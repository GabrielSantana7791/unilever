package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.classes.Page;
import com.news.gabrielSoft.classes.Post;
import com.news.gabrielSoft.classes.Session;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class EditPostController extends Page{
	@Autowired
	private Session login;
	
	@Autowired
	private Post post;

	@GetMapping(value= "/edit-post")
	public String editPost(int postId, Model model, HttpSession session) {
		try {
			title = "Edit post";
			pageFile = "editPost";
			pageInitializer(model, session);
			
			PostIndexEntity postIndex = post.postIndex(postId);
				
			model.addAttribute("postContent", postIndex);
			
			return "base";
		} catch (Exception e) {
			return "redirect:/login";
		}
	}

	@PostMapping(value= "/editPost/{postId}")
	public String editPost(@PathVariable int postId, PostIndexEntity postIndex, HttpSession httpSession, Model model) {
		try{
			login.userTestCredencial(httpSession, USER_ADMIN_LEVEL.admin);
			
			PostIndexEntity postDB = post.editPost(httpSession, postId, postIndex);
			
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "editPost");
			model.addAttribute(MODEL_ATTRIBUTES.message.toString(), "Success");
			model.addAttribute("postContent", postDB);
			return "base";
		}catch(Exception e) {
			return "redirect:/login";
		}
	}
}
