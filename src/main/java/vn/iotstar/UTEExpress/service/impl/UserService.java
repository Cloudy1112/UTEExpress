package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.User;
import vn.iotstar.UTEExpress.repository.UserRepository;
import vn.iotstar.UTEExpress.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
    private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(String id) {
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(String id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean activateEmail(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmailActive(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findByPhone(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatusOrder(Order order, Integer status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	

	
	}

