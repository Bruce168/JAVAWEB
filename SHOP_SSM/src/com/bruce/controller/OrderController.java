package com.bruce.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruce.model.Cart;
import com.bruce.model.CartItem;
import com.bruce.model.Orderitem;
import com.bruce.model.Orders;
import com.bruce.model.User;
import com.bruce.utils.Pager;

@Controller
@RequestMapping("order")
public class OrderController extends BaseController {

	/**
	 * 提交购物车订单
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addOrder")
	public String addOrder(HttpSession session, Model model) {

		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			model.addAttribute("message", "亲，您还没进行购物哦！");
			return "/msg";
		}

		User user = (User) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("user", new User());
			model.addAttribute("message", "亲，您还没有登录哦！");
			return "/login";
		}

		Orders order = new Orders();
		order.setOrdertime(new Date());
		order.setState(1);
		order.setUid(user.getUid());
		order.setTotal(cart.getTotal());
		Map<Integer, CartItem> cartItems = cart.getCartItems();
		Iterator<Integer> iterator = cart.getCartItems().keySet().iterator();
		while (iterator.hasNext()) {
			CartItem cartItem = cartItems.get(iterator.next());

			Orderitem orderitem = new Orderitem();
			orderitem.setCount(cartItem.getCount());
			orderitem.setSubtotal(cartItem.getSubtotal());
			orderitem.setPid(cartItem.getProduct().getPid());
			orderitem.setProduct(cartItem.getProduct());
			order.getOrderItems().add(orderitem);
		}

		super.getOrdersService().insertSelective(order);

		model.addAttribute("order", order);

		return "order";
	}

	@RequestMapping(value = "{currentPage}/{rowCount}/findOrderListByUserid")
	public String findOrderListByUserid(@PathVariable int currentPage, @PathVariable int rowCount,HttpSession session,Model model) {
		
		User user = (User) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("user", new User());
			model.addAttribute("message", "亲，您还没有登录哦！");
			return "/login";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", user.getUid());
		
		int ordersCount= super.getOrdersService().countSelectByParams(map);
		int pages=0;
		if (ordersCount % rowCount == 0) {
			pages = (ordersCount / rowCount);
		} else {
			pages = (ordersCount / rowCount) + 1;
		}
		
		int offset = (currentPage - 1) * rowCount;
		map.put("offset", offset);
		map.put("rowCount", rowCount);
		map.put("orderby", "pdate");
		
		List<Orders> orders = super.getOrdersService().selectByParams(map);
		
		Pager pager = new Pager();
		pager.setList(orders);
		pager.setRowCount(rowCount);
		pager.setCurrentPage(currentPage);
		pager.setPages(pages);
		
		//pager.setId(cid);
		pager.setUri("findProductListByCid.do");
		model.addAttribute("pager", pager);
		
		return "orderList";
	}

	@RequestMapping(value = "payOrder")
	public String payOrder(Orders order) {

		Orders o = super.getOrdersService().selectByPrimaryKey(order.getOid());
		o.setAddr(order.getAddr());
		o.setName(order.getName());
		o.setPhone(order.getPhone());
		o.setState(2);

		return "";
	}
	
	
}
