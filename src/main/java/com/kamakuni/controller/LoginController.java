package com.kamakuni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kamakuni.form.LoginForm;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("form",new LoginForm());
		mav.setViewName("login");
		return mav;
	}
		
}
