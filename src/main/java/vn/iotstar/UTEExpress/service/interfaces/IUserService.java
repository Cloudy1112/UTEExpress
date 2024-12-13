package vn.iotstar.UTEExpress.service.interfaces;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.User;

@Service
public interface IUserService {
	
	
	// Lấy danh sách tất cả người dùng
    List<User> findAll();

    // Tìm người dùng theo ID
    User findById(String id);

    // Tạo người dùng mới
    User createUser(User user);

    // Cập nhật thông tin người dùng
    User updateUser(String id, User user);

    // Xóa người dùng
    void deleteUser(String id);

    // Tìm kiếm người dùng theo từ khóa
    List<User> findByName(String name);

    // Kích hoạt email cho người dùng
    boolean activateEmail(String id);

    // Kiểm tra trạng thái email của người dùng
    boolean isEmailActive(String id);

    // Tìm người dùng theo số điện thoại
    User findByPhone(String phone);
	// Tạo đơn 
    void createOrder(Order order);
	// Huỷ đơn
    void cancelOrder(Order order);
    // Sửa trạng thái đơn hàng
    void updateStatusOrder(Order order, Integer status);
    //Sửa đơn hàng
    void updateOrder(Order order);
   
}
