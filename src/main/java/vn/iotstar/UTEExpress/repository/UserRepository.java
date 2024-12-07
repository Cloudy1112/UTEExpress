package vn.iotstar.UTEExpress.repository;

//import org.apache.catalina.User;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.UTEExpress.entity.User;

public interface UserRepository extends JpaRepository<User, String> { 

}
