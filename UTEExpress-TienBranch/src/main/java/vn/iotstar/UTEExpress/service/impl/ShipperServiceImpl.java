package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.repository.IOrderRepository;
import vn.iotstar.UTEExpress.repository.IShipperRepository;
import vn.iotstar.UTEExpress.service.interfaces.IShipperService;

@Service
public class ShipperServiceImpl implements IShipperService {

	@Autowired
	IShipperRepository shipperRepository;
	
	@Autowired
	IOrderRepository orderRepository;

	@Override
	public Optional<Shipper> findByName(String name) {
		  return shipperRepository.findByName(name);
	}

	@Override
	public Optional<Shipper> findByID(String IDShipper) {
		try {
            Integer shipperId = Integer.parseInt(IDShipper);
            return shipperRepository.findById(shipperId);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
	}

	@Override
	public Optional<Order> findOrderByIDOrder(String IDOrder) {
        return orderRepository.findById(IDOrder);

	}

	@Override
	public List<Order> findAllOrder(String IDShipper) {
		try {
            Integer shipperId = Integer.parseInt(IDShipper);
            return orderRepository.findByShipper_ShipperID(shipperId);
        } catch (NumberFormatException e) {
            return List.of();
        }
	}

	@Override
	public List<Order> findAllOrderBystatus(String IDShipper, Integer status) {
		try {
            Integer shipperId = Integer.parseInt(IDShipper);
            return orderRepository.findByShipper_ShipperIDAndStatus(shipperId, status);
        } catch (NumberFormatException e) {
            return List.of();
        }
	}

	@Override
	public Optional<Shipper> findByPost(String IDPost) {
		 return shipperRepository.findByPost_IDPost(IDPost);
	}

	@Override
	public void editProfile(Shipper shipper) {
        shipperRepository.save(shipper);
		
	}

	@Override
	public void editStatusOrder(String IDOrder, Integer status) {
		Optional<Order> orderOpt = orderRepository.findById(IDOrder);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setStatus(status);
            orderRepository.save(order);
        }
	}

	@Override
	public Optional<Shipper> findByID(Integer IDShipper) {
        return shipperRepository.findById(IDShipper);

	}

	@Override
	public List<Order> findAllOrderByStatus(String IDShipper, Integer status) {
        return findAllOrderBystatus(IDShipper, status);
	}

	@Override
	public void save(Shipper shipper) {
        shipperRepository.save(shipper);
		
	}

	@Override
	public void deleteById(Integer id) {
        shipperRepository.deleteById(id);
		
	}
	

 
}

