package com.bruce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.model.Categoryategory;
import com.bruce.model.Categorysecond;
import com.bruce.model.Product;

@Controller
@RequestMapping("product")
public class ProductController extends BaseController {

	@RequestMapping(value="{id}/findProductById")
	public String findProductById(@PathVariable int id,Model model,HttpServletRequest request){
		if (request.getSession().getAttribute("categoryategorys") == null) {
			List<Categoryategory> categoryategorys = super
					.getCategoryategoryService().selectByParams(null);
			request.getSession().setAttribute("categoryategorys",
					categoryategorys);
		}
		
		if (request.getSession().getAttribute("categoryseconds") == null) {
			List<Categorysecond> categoryseconds = super
					.getCategorysecondService().selectByParams(null);
			request.getSession().setAttribute("categoryseconds",
					categoryseconds);
		}
		
		
		Product product = super.getProductService().selectByPrimaryKey(id);
		model.addAttribute("product", product);
		return "product";
	}
	
}
