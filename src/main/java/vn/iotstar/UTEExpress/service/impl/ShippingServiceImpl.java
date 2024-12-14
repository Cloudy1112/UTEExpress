package vn.iotstar.UTEExpress.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Shipping;
import vn.iotstar.UTEExpress.repository.IShippingRepository;
import vn.iotstar.UTEExpress.service.IShippingServiceImpl;

@Service
public class ShippingServiceImpl implements IShippingServiceImpl{
	@Autowired
	private IShippingRepository shippingRepository;

	public Shipping findByOrderID(String orderID) {
		return shippingRepository.findByOrderID(orderID);
	}

	public <S extends Shipping> S save(S entity) {
		return shippingRepository.save(entity);
	}
	
	
}
