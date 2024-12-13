package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;
import java.util.Optional;

import vn.iotstar.UTEExpress.entity.Shipping;

public interface IShippingService {
	 // Lấy thông tin đơn hàng theo orderID
    Optional<Shipping> findByOrderId(String orderId);
    
    // Lấy tất cả đơn hàng
    List<Shipping> findAll();
    
    // Tạo mới hoặc cập nhật đơn hàng
    Shipping save(Shipping shipping);
    
    // Xóa đơn hàng theo orderID
    void deleteById(String orderId);
    
    // Tính tổng chi phí đơn hàng
    Integer calculateTotalShipping(Shipping shipping);
    
    // Cập nhật trạng thái đơn hàng
    Shipping updateStatus(String orderId, Integer statusOrderId);
}
