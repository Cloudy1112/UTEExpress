package vn.iotstar.UTEExpress.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.repository.ICustomerRepository;
import vn.iotstar.UTEExpress.service.ICityService;

@Service
public class CityServiceImpl implements ICityService{
	@Autowired
	ICustomerRepository cityRepository;
}
