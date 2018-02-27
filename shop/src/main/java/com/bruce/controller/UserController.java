package com.bruce.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "toLogin", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "toLogin", method = RequestMethod.POST)
	public String login(@ModelAttribute @Validated User user,
			BindingResult result, Model model) {

		List<ObjectError> allErrors = result.getAllErrors();

		for (ObjectError objectError : allErrors) {
			System.out.println(objectError.getDefaultMessage());
		}

		model.addAttribute("errors", allErrors);

		return "login";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute @Validated User user,
			BindingResult result, Model model) {
		List<ObjectError> allErrors = result.getAllErrors();

		for (ObjectError objectError : allErrors) {
			System.out.println(objectError.getDefaultMessage());
		}

		model.addAttribute("errors", allErrors);
		return "register";
	}
}
