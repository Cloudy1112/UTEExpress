package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;
import java.util.Optional;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.StatusOrder;

public interface IOrderStatusService {
	
	
	// Lấy tất cả các trạng thái đơn hàng
    List<StatusOrder> findAll();

    // Tìm trạng thái đơn hàng theo ID
    Optional<StatusOrder> findById(Integer idStatusOrder);

    // Thêm mới trạng thái đơn hàng
    StatusOrder save(StatusOrder statusOrder);

    // Xoá trạng thái đơn hàng theo ID
    void deleteById(Integer idStatusOrder);
    
    
    
}
