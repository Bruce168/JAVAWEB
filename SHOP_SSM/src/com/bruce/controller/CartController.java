package com.bruce.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.model.Cart;
import com.bruce.model.CartItem;
import com.bruce.model.Product;

@Controller
@RequestMapping("cart")
public class CartController extends BaseController {

	@RequestMapping(value = "addCart")
	public String addCart(Integer pid, Integer count, HttpServletRequest request) {

		Product product = super.getProductService().selectByPrimaryKey(pid);

		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(product);
		cartItem.setSubtotal(count * product.getShopPrice());

		Cart cart = getCart(request.getSession());
		Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
		map.put(product.getPid(), cartItem);
		cart.setCartItems(map);
		cart.setTotal(cart.getTotal() + cartItem.getSubtotal());
		
		request.setAttribute("cart", cart);
		
		return "cart";
	}

	private Cart getCart(HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");
		if (session.getAttribute("cart") == null) {
			cart = new Cart();
		}

		return cart;
	}

}
