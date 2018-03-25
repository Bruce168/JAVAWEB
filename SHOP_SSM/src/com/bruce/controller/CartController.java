package com.bruce.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.model.Cart;
import com.bruce.model.CartItem;
import com.bruce.model.Product;

@Controller
@RequestMapping("cart")
public class CartController extends BaseController {

	@RequestMapping(value = "clearCart")
	public String clearCart(HttpServletRequest request) {
		request.getSession().setAttribute("cart", null);
		return "redirect:/cart/toCart.do";
	}

	@RequestMapping(value = "{pid}/deleteCart")
	public String deleteCart(@PathVariable int pid, HttpServletRequest request) {
		Cart cart = getCart(request.getSession());
		cart.removeCart(pid);

		return "redirect:/cart/toCart.do";
	}

	@RequestMapping(value = "toCart")
	public String toCart(HttpServletRequest request) {

		return "cart";
	}

	@RequestMapping(value = "addCart")
	public String addCart(Integer pid, Integer count, HttpServletRequest request) {

		Product product = super.getProductService().selectByPrimaryKey(pid);

		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(product);
		cartItem.setSubtotal(count * product.getShopPrice());

		Cart cart = getCart(request.getSession());

		Map<Integer, CartItem> cartItems = cart.getCartItems();
		if (cartItems == null || cartItems.size() == 0) {
			cartItems = new LinkedHashMap<Integer, CartItem>();
		}

		CartItem cartItem_ = cartItems.get(product.getPid());
		if (cartItem_ == null) {
			cartItems.put(product.getPid(), cartItem);
		} else {
			cartItem.setCount(cartItem_.getCount() + count);
			cartItem.setSubtotal(cartItem_.getSubtotal()
					+ cartItem.getSubtotal());
			cartItems.put(product.getPid(), cartItem);
		}

		cart.setCartItems(cartItems);
		
		Iterator<Integer> its= cartItems.keySet().iterator();
		cart.setTotal(0.0);
		while(its.hasNext()){
			CartItem ci = cartItems.get(its.next());
			cart.setTotal(cart.getTotal() + ci.getSubtotal());
		}

		request.getSession().setAttribute("cart", cart);

		return "redirect:/cart/toCart.do";
	}

	private Cart getCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (session.getAttribute("cart") == null) {
			cart = new Cart();
		}
		return cart;
	}

}
