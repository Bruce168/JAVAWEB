package com.bruce.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.model.User;
import com.bruce.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("{id}/show")
	public String findById(@PathVariable long id, HttpServletRequest request) {

		User user = userService.findById(id);

		request.setAttribute("user", user);

		System.out.println("xxx:" + user.getUsername());

		return "user/show";
	}

}
