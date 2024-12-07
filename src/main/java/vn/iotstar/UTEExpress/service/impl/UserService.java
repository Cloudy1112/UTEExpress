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
		return userRepository.findAll();
	}

	@Override
	public User findById(String id) {
		 Optional<User> user = userRepository.findById(id);
	        return user.orElse(null);
	}

	@Override
	public User create(User user) {
		 return userRepository.save(user);
	}

	@Override
	public User update(String id, User user) {
		if (userRepository.existsById(id)) {
            user.setIDUser(id); // Giữ nguyên ID khi cập nhật
            return userRepository.save(user);
        }
        return null;
	}

	@Override
	public void delete(String id) {
		  userRepository.deleteById(id);
    
	}

	@Override
	public List<User> search(String keyword) {
		 return userRepository.searchByKeyword(keyword);
	}

	@Override
	public boolean activateEmail(String id) {
		Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setIsEmailActive(true);
            userRepository.save(existingUser);
            return true;
        }
        return false;
	}

	@Override
	public boolean isEmailActive(String id) {
		 User user = findById(id);
	        return user != null && Boolean.TRUE.equals(user.getIsEmailActive());
	}

	@Override
	public User findByPhone(String phone) {
	      return userRepository.findByPhone(phone);
	    }
	}

