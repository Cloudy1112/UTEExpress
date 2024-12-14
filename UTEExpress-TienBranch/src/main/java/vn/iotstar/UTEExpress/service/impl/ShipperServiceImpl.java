package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.entity.Shipping;
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
	public Shipper getShipperById(Integer id) {
		return shipperRepository.findById(id).orElse(null);
	}

	@Override
	public Shipper getShipperByUsername(String username) {
        return shipperRepository.findByAccountUsername(username);

	}

	@Override
	public List<Shipper> getShippersByCity(String city) {
		return shipperRepository.findByCity(city);
	}

	@Override
	public List<Shipper> getShippersByStatus(Integer statusShipper) {
		  return shipperRepository.findByStatusShipper(statusShipper);
	}

	@Override
	public void saveOrUpdateShipper(Shipper shipper) {
		shipperRepository.save(shipper);
	}

	@Override
	public void deleteShipperById(Integer id) {
		 shipperRepository.deleteById(id);
    
	}

	public Optional<Shipper> findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Shipper updatedShipper) {
		
	}

	

 
}

