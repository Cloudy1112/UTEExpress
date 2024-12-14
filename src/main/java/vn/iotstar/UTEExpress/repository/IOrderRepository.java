package vn.iotstar.UTEExpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, String>{
	
	@Query("SELECT o FROM Order o WHERE o.customer.customerID = :customerID")
    List<Order> findOrderByCustomerID(@Param("customerID") Integer customerID);
	
	//tìm order dửa theo phương thức vận chuyển
	@Query("SELECT o FROM Order o WHERE o.transport.transportType = :transportType")
    List<Order> findOrderByTransportType(@Param("transportType") String transportType);
}
