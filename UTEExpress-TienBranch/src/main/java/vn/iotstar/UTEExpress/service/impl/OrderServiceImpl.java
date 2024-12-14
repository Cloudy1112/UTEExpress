package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.repository.IOrderRepository;
import vn.iotstar.UTEExpress.service.interfaces.IOrderService;

public class OrderServiceImpl implements IOrderService {
	@Autowired
	IOrderRepository orderRepository;

	@Override
	public List<Order> getOrdersByTransportType(String transportType) {
        return orderRepository.findOrdersByTransportType(transportType);

	}

	@Override
	public List<Order> getOrdersByTransportTypeAndStatus(String transportType, Integer status) {
        return orderRepository.findOrdersByTransportTypeAndStatus(transportType, status);

	}

	@Override
	public Order getOrderById(String orderID) {
        return orderRepository.findByOrderID(orderID);

	}

	@Override
	public void saveOrder(Order order) {
		orderRepository.save(order);		
	}

	@Override
	public void updateOrderStatus(String orderID, Integer newStatus) {
		  Order order = orderRepository.findByOrderID(orderID);
	        if (order != null) {
	            order.setStatus(newStatus);
	            orderRepository.save(order);
	        }
	}

	public List<Order> findByIdShipperAndStatus(String id, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> findByIdStatusOrder(String id, int i) {
	
		return null;
	}
	
	


}
