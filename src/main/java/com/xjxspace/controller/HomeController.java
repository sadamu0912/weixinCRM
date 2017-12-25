package com.xjxspace.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjxspace.util.Common;

@Controller
public class HomeController {
	
	
	@RequestMapping("/login")
	public String index(Model model,HttpServletRequest req) {
		if(Common.isLogin(req)){
			return "index";
		}
		return "login";
	}
	
	@RequestMapping("/")
	public String login(Model model,HttpServletRequest req) {
		return "login";
	}

	@RequestMapping("/tabs")
	public String tabs(Model model,HttpServletRequest req) {
		return "tabs";
	}
}
