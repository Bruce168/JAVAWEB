package com.bruce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bruce.model.User;
import com.bruce.service.UserService;
import com.bruce.utils.UUIDUtils;

@Controller
@RequestMapping("controller")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("list")
	public String list(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user/list";
	}

	@RequestMapping("show")
	public String show(Model model) {
		User user = userService.findById(1L);
		model.addAttribute("user", user);
		return "user/show";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute @Validated User user,
			BindingResult result, Model model, HttpServletRequest request) {

		List<ObjectError> allErrors = result.getAllErrors();

		if (allErrors != null && allErrors.size() > 0) {
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}

			model.addAttribute("errors", allErrors);
		} else {
			request.getSession().setAttribute("user", user);
		}

		return "login";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute @Validated User user,
			BindingResult result, Model model) {
		List<ObjectError> allErrors = result.getAllErrors();

		if (allErrors != null && allErrors.size() > 0) {
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}

			model.addAttribute("errors", allErrors);
		} else {
			String code = UUIDUtils.getUUID();
			user.setCode(code);

			userService.save(user);
		}

		return "redirect:register.do";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:login.do";
	}

	@RequestMapping(value = "{code}/active")
	public String active(@PathVariable String code, Model model) {
		User user = userService.findByCode(code);
		if (user != null) {
			user.setState(1);

			userService.update(user);
		} else {
			model.addAttribute("errors", "激活失败：激活码错误");
		}

		return "msg";
	}

	@RequestMapping(value = "checkUsername")
	public @ResponseBody
	Map<String,Object> checkUsername(@RequestParam String username, Model model) {

		User u = userService.findByUsername(username);
		Map<String,Object> map=new HashMap<String,Object>();
		if (u != null) {
			map.put("message", "用户名已经存在")  ;
		}else{
			map.put("message", "")  ;
		}

		return map;
	}
}
