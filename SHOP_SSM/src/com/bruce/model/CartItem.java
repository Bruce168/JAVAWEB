package com.bruce.model;

import lombok.Getter;
import lombok.Setter;

public class CartItem {

	@Getter
	@Setter
	private Product product;
	/**
	 * 产品数量、
	 */
	@Getter
	@Setter
	private Integer count;
	/**
	 * 产品总价
	 */
	@Getter
	@Setter
	private Double subtotal;
}
