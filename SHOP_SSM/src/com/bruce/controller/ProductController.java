package com.bruce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.model.Categoryategory;
import com.bruce.model.Categorysecond;
import com.bruce.model.Product;
import com.bruce.utils.Pager;

@Controller
@RequestMapping("product")
public class ProductController extends BaseController {

	/**
	 * 根据产品id查询产品明细
	 * 
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "{id}/findProductById")
	public String findProductById(@PathVariable int id, Model model,
			HttpServletRequest request) {
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

	/**
	 * 点击一级分类显示产品列表
	 * 
	 * @param cid
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "{cid}/{currentPage}/{rowCount}/findProductListByCid.do")
	public String findProductListByCid(@PathVariable int cid,@PathVariable int currentPage, @PathVariable int rowCount, Model model,
			HttpServletRequest request) {
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

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		
		int productCount = super.getProductService().countSelectByCid(map);
		int pages = 0;
		if (productCount % rowCount == 0) {
			pages = (productCount / rowCount);
		} else {
			pages = (productCount / rowCount) + 1;
		}

		int offset = (currentPage - 1) * rowCount;

		map.put("offset", offset);
		map.put("rowCount", rowCount);
		map.put("orderby", "pdate");
		
		List<Product> products = super.getProductService().selectByCid(map);
		
		Pager pager = new Pager();
		pager.setList(products);
		pager.setRowCount(rowCount);
		pager.setCurrentPage(currentPage);
		pager.setPages(pages);
		
		pager.setId(cid);
		pager.setUri("findProductListByCid.do");
		model.addAttribute("pager", pager);
		

		return "productList";
	}

	/**
	 * 点击二级分类显示产品列表
	 * 
	 * @param csid
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "{csid}/{currentPage}/{rowCount}/findProductListByCsid.do")
	public String findProductListByCsid(@PathVariable int csid,
			@PathVariable int currentPage, @PathVariable int rowCount,
			Model model, HttpServletRequest request) {
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

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("csid", csid);

		int productCount = super.getProductService().countSelectByCsid(map);
		int pages = 0;
		if (productCount % rowCount == 0) {
			pages = (productCount / rowCount);
		} else {
			pages = (productCount / rowCount) + 1;
		}

		int offset = (currentPage - 1) * rowCount;

		map.put("offset", offset);
		map.put("rowCount", rowCount);
		map.put("orderby", "pdate");

		List<Product> products = super.getProductService().selectByCsid(map);

		Pager pager = new Pager();
		pager.setList(products);
		pager.setRowCount(rowCount);
		pager.setCurrentPage(currentPage);
		pager.setPages(pages);
		
		pager.setId(csid);
		pager.setUri("findProductListByCsid.do");
		
		model.addAttribute("pager", pager);
		return "productList";
	}
}
