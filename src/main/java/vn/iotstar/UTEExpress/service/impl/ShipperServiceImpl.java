package vn.iotstar.UTEExpress.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.repository.IShipperRepository;
import vn.iotstar.UTEExpress.service.IShipperService;

@Service
public class ShipperServiceImpl implements IShipperService{
	@Autowired
	IShipperRepository shipperRepository;
	@Override
	public Optional<Shipper> findByShipperID(Integer shipperID) {
		// TODO Auto-generated method stub
		return shipperRepository.findById(shipperID);
	}
	
}
