package vn.iotstar.UTEExpress.service;

import vn.iotstar.UTEExpress.entity.Shipping;

public interface IShippingService  {

	<S extends Shipping> S save(S entity);

	Shipping findByOrderID(String orderID);

}
