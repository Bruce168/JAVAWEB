package com.bruce.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.model.User;
import com.bruce.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("list")
	public String list(Model model) {
		List<User> users = userService.list();
		model.addAttribute("users", users);
		return "user/list";
	}

	@RequestMapping("show")
	public String show(Model model) {
		User user = userService.findById(1L);
		model.addAttribute("user", user);
		return "user/show";
	}
}
