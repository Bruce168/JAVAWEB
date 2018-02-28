package com.bruce.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bruce.model.User;
import com.bruce.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-servlet.xml" })
public class UserServiceImplTest {

	@Resource
	private UserService userService;

	@Test
	public void testfFindByCode() {

		User user = userService.findByCode("");
		Assert.assertEquals(user, null);

	}

	@Test
	public void testfindByUsername(){
		
		User user = userService.findByUsername("bbb");
		Assert.assertEquals(user.getUsername(), "111");

	}
}
