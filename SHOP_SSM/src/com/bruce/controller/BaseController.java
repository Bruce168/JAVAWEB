package com.bruce.controller;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import com.bruce.service.CategoryategoryService;
import com.bruce.service.CategorysecondService;
import com.bruce.service.OrdersService;
import com.bruce.service.ProductService;
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
	
	@Resource
	@Getter
	@Setter
	private CategorysecondService categorysecondService;
	
	@Resource
	@Getter
	@Setter
	private ProductService productService;
	
	@Resource
	@Getter
	@Setter
	private OrdersService ordersService;
}
