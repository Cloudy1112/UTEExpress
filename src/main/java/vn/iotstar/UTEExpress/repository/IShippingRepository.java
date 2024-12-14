package vn.iotstar.UTEExpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Shipping;

@Repository
public interface IShippingRepository extends JpaRepository<Shipping, Integer>{
	@Query("SELECT s FROM Shipping s WHERE s.orderID = :orderID")
    Shipping findByOrderID(@Param("orderID") String orderID);
}
