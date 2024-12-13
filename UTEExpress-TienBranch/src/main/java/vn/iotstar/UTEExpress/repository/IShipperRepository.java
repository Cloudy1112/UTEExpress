package vn.iotstar.UTEExpress.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.UTEExpress.entity.Shipper;

@Repository
public interface IShipperRepository extends JpaRepository<Shipper, Integer> {

	Optional<Shipper> findByName(String name);
	
	List<Shipper> findByStatusShipper(Integer statusShipper);
	
	Optional<Shipper> findByPost_IDPost(String IDPost);
	
	Optional<Shipper> findByAccount_Username(String username);
	
	
	//@Query("SELECT o FROM Order o WHERE o.IDShipper = :IDShipper")
    //List<Order> findOrdersByShipperId(@Param("IDShipper") String IDShipper);
	
	//@Query("SELECT o FROM Order o WHERE o.IDShipper = :IDShipper AND o.status = :status")
	//List<Order> findOrdersByShipperIdAndStatus(@Param("IDShipper") String IDShipper, @Param("status") Integer status);

	
	
}
