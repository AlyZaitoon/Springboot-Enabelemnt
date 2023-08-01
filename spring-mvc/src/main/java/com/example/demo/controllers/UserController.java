package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	@RequestMapping(value="/register" ,method=RequestMethod.GET)
	public String register(Map<String,Object> map) {
		map.put("user",new UserModel());
		return "user/register";
	}
	@RequestMapping(value="/delete/{userId}" ,method=RequestMethod.DELETE)
	public void delete(@PathVariable("userId") Long userId) {
		userService.delete(userId);
	}
	@RequestMapping(value="/create" ,method=RequestMethod.POST)
	public String create(UserModel user,Map<String,Object> map) {
		userService.create(user);
		return "redirect:/user/details/" + user.getId();
	}
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@RequestBody UserModel user) {
		userService.update(user);
		return "redirect:/user/details/" + user.getId();
	}
	@RequestMapping(value="/details/{userId}" ,method=RequestMethod.GET)
	public String details( @PathVariable("userId") Long userId, Map<String,Object> map) {
		UserModel user = userService.find(userId);
		map.put("fname",user.getFname());
		map.put("lname",user.getLname());
		map.put("email",user.getEmail());
		map.put("mobile",user.getMobile());
		return "user/details";
	}
}
