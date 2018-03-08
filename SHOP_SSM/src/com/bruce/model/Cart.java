package com.bruce.model;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class Cart {
	@Getter
	@Setter
	private Map<Integer, CartItem> cartItems = new LinkedHashMap<Integer, CartItem>();

	@Getter
	@Setter
	private Double total=0.0;

	/**
	 * 清空购物车
	 */
	public void clearCart() {
		cartItems.clear();
		total = 0.0;
	}

	/**
	 * 删除某一项产品
	 * 
	 * @param pid
	 */
	public void removeCart(Integer pid) {
		CartItem cartItem = cartItems.remove(pid);
		total -= cartItem.getSubtotal();
	}

	/**
	 * 添加到购物车
	 * 
	 * @param cartItem
	 */
	public void addCart(CartItem cartItem) {
		Integer pid = cartItem.getProduct().getPid();

		if (cartItems.containsKey(pid)) {
			cartItems.get(pid).setCount(
					cartItems.get(pid).getCount() + cartItem.getCount());
		} else {
			cartItems.put(cartItem.getProduct().getPid(), cartItem);
		}

		total += cartItem.getSubtotal();
	}
}
