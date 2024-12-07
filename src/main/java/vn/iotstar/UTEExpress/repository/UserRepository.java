package vn.iotstar.UTEExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.UTEExpress.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	


}
