package vn.iotstar.UTEExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	
	

}
