package com.bruce.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Orders {
	@Getter
	@Setter
	private Integer oid;

	@Getter
	@Setter
	private Double total;

	@Getter
	@Setter
	private Date ordertime;

	@Getter
	@Setter
	private Integer state;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String phone;

	@Getter
	@Setter
	private String addr;

	@Getter
	@Setter
	private Integer uid;

	@Getter
	@Setter
	private Set<Orderitem> orderItems = new HashSet<Orderitem>();

}