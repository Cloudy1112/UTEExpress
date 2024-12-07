package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.User;
import vn.iotstar.UTEExpress.repository.UserRepository;
import vn.iotstar.UTEExpress.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
    private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(String id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> search(String keyword) {
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

	
	}

