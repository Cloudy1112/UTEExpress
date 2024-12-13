package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.repository.IShipperRepository;
import vn.iotstar.UTEExpress.service.IShipperService;

@Service
public class ShipperServiceImpl implements IShipperService{
	@Autowired
	private IShipperRepository shipperRepository;

	public List<Shipper> findShippersByIDPost(Integer postID) {
		return shipperRepository.findShippersByIDPost(postID);
	}

	public <S extends Shipper> S save(S entity) {
		return shipperRepository.save(entity);
	}

	public Optional<Shipper> findById(Integer id) {
		return shipperRepository.findById(id);
	}

	public void delete(Shipper entity) {
		shipperRepository.delete(entity);
	}
	
	
}
