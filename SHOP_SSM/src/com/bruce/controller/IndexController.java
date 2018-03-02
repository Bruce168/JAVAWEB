package com.bruce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.model.Categoryategory;

@Controller
public class IndexController extends BaseController{

	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("categoryategorys") == null) {
			List<Categoryategory> categoryategorys = super.getCategoryategoryService()
					.selectByParams(null);
			request.getSession().setAttribute("categoryategorys",
					categoryategorys);
		}
		return "index";
	}

	@RequestMapping(value = "menu")
	public String menu() {

		return "menu";
	}

}
