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
	
	//tìm order pending dưa tren orderstatus và src city
	@Query("SELECT o FROM Order o " +
		       "JOIN Shipping s ON o.orderID = s.orderID " +
		       "JOIN StatusOrder so ON s.statusOrderID = so.IDStatusOrder " +
		       "WHERE so.IDStatusOrder = :statusOrderID " +
		       "AND o.sourceCity = :sourceCity " +
		       "AND s.shipper IS NULL")
	List<Order> findOrderByOrderStatusAndSourceCity(Integer statusOrderID, String sourceCity);

    
  //tìm order pending dưa tren orderstatus và dest city
	@Query("SELECT o FROM Order o " +
		       "JOIN Shipping s ON o.orderID = s.orderID " +
		       "JOIN StatusOrder so ON s.statusOrderID = so.IDStatusOrder " +
		       "WHERE so.IDStatusOrder = :statusOrderID " +
		       "AND o.destCity = :destCity " +
		       "AND s.shipper IS NULL")
	List<Order> findOrderByOrderStatusAndDestCity(Integer statusOrderID, String destCity);

	@Query("SELECT o FROM Order o " +
		       "WHERE o.sourceCity = :cityName " +
		       "OR o.destCity = :cityName")
	List<Order> findOrdersBySourceCityAndDestCity(String cityName);


}
