package vn.iotstar.UTEExpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {
	
	@Query("select o from Order o where o.customer.customerID = :customerID")
	List <Order> findAllByCustomerID(@Param("customerID") Integer customerID);
}
