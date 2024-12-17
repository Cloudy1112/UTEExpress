package vn.iotstar.UTEExpress.service;

import java.util.List;
import java.util.Optional;

import vn.iotstar.UTEExpress.entity.Manager;

public interface IManagerService {

	long count();

	Optional<Manager> findById(Integer id);

	List<Manager> findAll();

	<S extends Manager> S save(S entity);

	Manager findManagerByUsername(String username);

}
