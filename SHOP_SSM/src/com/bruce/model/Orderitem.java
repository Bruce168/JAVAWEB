package com.bruce.model;

import lombok.Getter;
import lombok.Setter;

public class Orderitem {
	@Getter
	@Setter
    private Integer itemid;

	@Getter
	@Setter
    private Integer count;

	@Getter
	@Setter
    private Double subtotal;

	@Getter
	@Setter
    private Integer pid;

	@Getter
	@Setter
    private Integer oid;

	@Getter
	@Setter
	private Product product;
	
	@Getter
	@Setter
	private Orders order;
}