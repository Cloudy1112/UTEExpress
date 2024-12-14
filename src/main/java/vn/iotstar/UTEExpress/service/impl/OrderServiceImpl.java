package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.repository.IOrderRepository;
import vn.iotstar.UTEExpress.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	private IOrderRepository orderRepository;

	public List<Order> findOrderByOrderStatusAndSourceCity(Integer statusOrderID, String sourceCity) {
		return orderRepository.findOrderByOrderStatusAndSourceCity(statusOrderID, sourceCity);
	}

	public Optional<Order> findById(String id) {
		return orderRepository.findById(id);
	}

	
}
