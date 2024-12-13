package vn.iotstar.UTEExpress.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByPhone(String phone); 
	
	Optional<User> findByCccd(String cccd); 
	
	List<User> findAll();

}
