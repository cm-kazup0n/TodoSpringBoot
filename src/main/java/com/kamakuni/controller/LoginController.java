package com.kamakuni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
