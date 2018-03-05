package com.bruce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.model.Categoryategory;
import com.bruce.model.Product;
import com.bruce.utils.CommonUtils;
import com.bruce.utils.ProductUtils;

@Controller
public class IndexController extends BaseController {

	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("categoryategorys") == null) {
			List<Categoryategory> categoryategorys = super
					.getCategoryategoryService().selectByParams(null);
			request.getSession().setAttribute("categoryategorys",
					categoryategorys);
		}

		Map<String, Object> map_hot = new HashMap<String, Object>();
		map_hot.put("isHot", ProductUtils.IS_HOT);
		map_hot.put("orderby", "pdate");
		map_hot.put("offset", 0);
		map_hot.put("rowCount", 10);

		List<Product> products_hot = super.getProductService().selectByParams(
				map_hot);
		model.addAttribute("products_hot", products_hot);

		Map<String, Object> map_new = new HashMap<String, Object>();
		map_new.put("orderby", "pdate");
		map_new.put("offset", 0);
		map_new.put("rowCount", 10);
		List<Product> products_new = super.getProductService().selectByParams(
				map_new);
		model.addAttribute("products_new", products_new);

		String path = CommonUtils.getPath(request.getHeader("user-agent"));

		return path + "index";
	}

}
