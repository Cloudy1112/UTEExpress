package vn.iotstar.UTEExpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, String>{

	// Tìm tất cả các đơn hàng theo loại vận chuyển
    @Query("SELECT o FROM Order o WHERE o.transport.transportType = ?1")
    List<Order> findOrdersByTransportType(String transportType);

    // Tìm các đơn hàng theo trạng thái và loại vận chuyển (ví dụ: đơn hàng đang xử lý)
    @Query("SELECT o FROM Order o WHERE o.transport.transportType = ?1 AND o.status = ?2")
    List<Order> findOrdersByTransportTypeAndStatus(String transportType, Integer status);

    // Tìm đơn hàng theo mã đơn hàng
    Order findByOrderID(String orderID);
}

