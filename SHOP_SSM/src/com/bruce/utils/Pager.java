package com.bruce.utils;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Pager {

	@SuppressWarnings("rawtypes")
	@Getter
	@Setter
	private List list;
	@Getter
	@Setter
	private Integer rowCount;
	@Getter
	@Setter
	private Integer currentPage;
	@Getter
	@Setter
	private Integer pages;
	@Getter
	@Setter
	private String uri;
	@Getter
	@Setter
	private Integer id;
}
