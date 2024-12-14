package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;
import java.util.Optional;

import vn.iotstar.UTEExpress.entity.Order;

public interface IOrderService {
	 	List<Order> getOrdersByTransportType(String transportType);

	    List<Order> getOrdersByTransportTypeAndStatus(String transportType, Integer status);

	    Order getOrderById(String orderID);

	    void saveOrder(Order order);

	    void updateOrderStatus(String orderID, Integer newStatus);
	
}
