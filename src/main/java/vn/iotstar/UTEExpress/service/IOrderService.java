package vn.iotstar.UTEExpress.service;

import java.util.List;

import vn.iotstar.UTEExpress.entity.Order;

public interface IOrderService {

	<S extends Order> S save(S entity);
	List <Order> findAllByCustomerID(Integer customerID);
	
}
