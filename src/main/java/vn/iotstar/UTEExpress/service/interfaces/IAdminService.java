package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;
import java.util.Optional;

import vn.iotstar.UTEExpress.entity.Manager;

public interface IAdminService {
	
	//manager
	void delete(Manager entity);

	void deleteById(String id);

	long count();

	Optional<Manager> findById(String id);

	List<Manager> findAll();

	<S extends Manager> S save(S entity);
	
	// shipper
	
	// customer
	
	// order
	
	// voucher
	
	

}
