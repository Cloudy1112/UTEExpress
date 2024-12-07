package vn.iotstar.UTEExpress.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Manager;
import vn.iotstar.UTEExpress.entity.Shipper;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {
	Optional<Manager> findByUsername (String username );
	
	/*
	 * @NativeQuery("select idshipper, address, birth, cccd, city, gender, name, password, phone, picture, status_ship, idmanager, idpost  "
	 * + "from shippers " + "where s.IDPost == m.IDPost ")
	 */
	
	@Query("SELECT s FROM Shipper s WHERE s.manager.id = :IdManager")
	List<Shipper> findByShipperWorkPost(@Param("IdManager") String IdManager);

	
	//con thieu o duoi nua

}
