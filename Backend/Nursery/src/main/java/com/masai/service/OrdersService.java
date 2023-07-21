package com.masai.service;

import java.util.List;

import com.masai.model.Orders;

public interface OrdersService {
	
	public Orders addOrders(Orders order);
	public Orders updateOrders(Orders order);
	public Orders deleteOrders(int orderId);
	public Orders viewOrders(int orderId);
	public List< Orders> viewAllOrders();

}
