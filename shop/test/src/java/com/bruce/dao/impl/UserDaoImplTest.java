package com.bruce.dao.impl;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bruce.dao.UserMapper;
import com.bruce.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-servlet.xml" })
public class UserDaoImplTest {

	@Autowired
	private UserMapper userDao;

	@Before
	public void setUp() throws Exception {
		// BeanFactory beanFactory = new ClassPathXmlApplicationContext(
		// "applicationContext.xml");
		// userDao = (UserDao) beanFactory.getBean("userDao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMin() {

	}

	@Test
	public void testfFindByCode() {

		User user = userDao.findByCode("");
		Assert.assertNotEquals(user, null);

	}

}
