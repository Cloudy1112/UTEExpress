package vn.iotstar.UTEExpress.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Customer;
import vn.iotstar.UTEExpress.repository.ICustomerRepository;
import vn.iotstar.UTEExpress.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerRepository customerReposotory;
	
	// coche
	public List<Customer> findInactiveCustomersByCity(String cityName) {
		return customerReposotory.findInactiveCustomersByCity(cityName);
	}

	public Customer findCustomerByUserName(String username) {
		return customerReposotory.findCustomerByUserName(username);
	}

	public <S extends Customer> S save(S entity) {
		return customerReposotory.save(entity);
	}

	public void delete(Customer entity) {
		customerReposotory.delete(entity);
	}
	
	
	// end coche
	
	
}
