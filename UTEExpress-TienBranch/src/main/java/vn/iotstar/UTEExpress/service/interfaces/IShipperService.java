package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;
import java.util.Optional;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Shipper;

public interface IShipperService {
	
	public Optional<Shipper> findByName(String name);
	public Optional<Shipper> findByID(String IDShipper);
	public Optional<Order> findOrderByIDOrder(String IDOrder);
	public List<Order> findAllOrder(String IDShipper);
	
	public List<Order> findAllOrderBystatus(String IDShipper, Integer status);
	public Optional<Shipper> findByPost(String IDPost);
	
	void editProfile(Shipper shipper);
	void editStatusOrder(String IDOrder, Integer status);
	Optional<Shipper> findByID(Integer IDShipper);
	List<Order> findAllOrderByStatus(String IDShipper, Integer status);
	void save(Shipper shipper);
	void deleteById(Integer id);

}
