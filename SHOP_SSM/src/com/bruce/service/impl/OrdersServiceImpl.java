package com.bruce.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bruce.dao.OrderitemMapper;
import com.bruce.dao.OrdersMapper;
import com.bruce.model.Orderitem;
import com.bruce.model.Orders;
import com.bruce.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Resource
	private OrdersMapper ordersMapper;
	@Resource
	private OrderitemMapper orderitemMapper;

	public int deleteByPrimaryKey(Integer id) {

		return ordersMapper.deleteByPrimaryKey(id);
	}

	public int insert(Orders record) {
		return ordersMapper.insert(record);
	}

	public int insertSelective(Orders record) {
		int result = ordersMapper.insertSelective(record);
		Set<Orderitem> orderItems = record.getOrderItems();
		Iterator<Orderitem> its = orderItems.iterator();
		while (its.hasNext()) {
			Orderitem orderItem = its.next();
			orderItem.setOid(record.getOid());
			result += orderitemMapper.insertSelective(orderItem);
		}

		return result;
	}

	public Orders selectByPrimaryKey(Integer id) {
		return ordersMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Orders record) {
		return ordersMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Orders record) {
		return ordersMapper.updateByPrimaryKey(record);
	}

	public List<Orders> selectByParams(Map<String, Object> map) {
		List<Orderitem> orderItems = orderitemMapper.selectByParams(map);
		List<Orders> orders = new ArrayList<Orders>();
		for (Orderitem orderItem : orderItems) {
			boolean flag = false;
			for (int i = 0; i < orders.size(); i++) {
				if (orders.get(i).getOid().equals(orderItem.getOid()) ) {
					flag=true;
					orders.get(i).getOrderItems().add(orderItem);
				}
			}
			if(!flag){
				Orders order=orderItem.getOrder();
				order.getOrderItems().add(orderItem);
				orders.add(order);
			}
		}

		return orders;
	}

	public int countSelectByParams(Map<String, Object> map) {
		return ordersMapper.countSelectByParams(map);
	}

}
