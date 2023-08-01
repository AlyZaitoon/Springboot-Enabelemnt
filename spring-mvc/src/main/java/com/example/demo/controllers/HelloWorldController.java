package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String SayHello(ModelMap model) {
		model.addAttribute("message", "Welcome From Spring MVC");
		return "welcome";
	}
	@RequestMapping(value="/helloAgain/{user}",method = RequestMethod.GET)
	public String SayHelloAgain(@PathVariable("user")String user, ModelMap model) {
		model.addAttribute("message", "Welcome Again From Spring MVC");
		model.addAttribute("userdata", user);
		return "welcome";
	}	
}