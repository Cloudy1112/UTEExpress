package vn.iotstar.UTEExpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.iotstar.UTEExpress.entity.Shipping;

public interface IShippingRepository extends JpaRepository<Shipping, String>{

	 // Lấy danh sách đơn hàng chưa giao của shipper
    //@Query("SELECT s FROM Shipping s WHERE s.shipper.shipperID = :shipperID AND s.status = 1")
    List<Shipping> findPendingOrdersByShipper(String shipperID);

    // Lấy danh sách đơn hàng đã giao thành công của shipper
    //@Query("SELECT s FROM Shipping s WHERE s.shipper.shipperID = :shipperID AND s.status = 2")
    List<Shipping> findCompletedOrdersByShipper(String shipperID);

    // Lấy danh sách đơn hàng giao thất bại của shipper
    //@Query("SELECT s FROM Shipping s WHERE s.shipper.shipperID = :shipperID AND s.status = 3")
    List<Shipping> findFailedOrdersByShipper(String shipperID);
	
	
	
}
