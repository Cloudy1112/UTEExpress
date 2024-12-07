package vn.iotstar.UTEExpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	// Tìm kiếm người dùng theo tên hoặc thành phố
    @Query("SELECT u FROM User u WHERE u.name LIKE %?1% OR u.city LIKE %?1%")
    List<User> searchByKeyword(String keyword);

    // Tìm người dùng theo số điện thoại
    User findByPhone(String phone);;
}
