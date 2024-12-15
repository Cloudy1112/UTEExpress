package vn.iotstar.UTEExpress.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.repository.IOrderRepository;
import vn.iotstar.UTEExpress.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	IOrderRepository orderRepository;
	
	@Override
	public <S extends Order> S save(S entity) {
		return orderRepository.save(entity);
	}

	@Override
	public List<Order> findAllByCustomerID(Integer customerID) {
		// TODO Auto-generated method stub
		return orderRepository.findAllByCustomerID(customerID);
	}

	@Override
	public Order findByID(String orderID) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderID).get();
	}

}
