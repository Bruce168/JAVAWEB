package com.bruce.controller;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import com.bruce.service.CategoryategoryService;
import com.bruce.service.UserService;

public class BaseController {

	@Resource
	@Getter
	@Setter
	private UserService userService;

	@Resource
	@Getter
	@Setter
	private CategoryategoryService categoryategoryService;
}
