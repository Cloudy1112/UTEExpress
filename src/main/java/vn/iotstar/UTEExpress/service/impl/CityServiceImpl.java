package vn.iotstar.UTEExpress.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.City;
import vn.iotstar.UTEExpress.repository.ICityRepository;
import vn.iotstar.UTEExpress.service.ICityService;

@Service
public class CityServiceImpl implements ICityService{
	@Autowired
	ICityRepository cityRepository;
	
	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}
	
}
