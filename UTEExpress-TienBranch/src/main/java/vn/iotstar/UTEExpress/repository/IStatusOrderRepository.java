package vn.iotstar.UTEExpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.UTEExpress.entity.StatusOrder;

public interface IStatusOrderRepository extends JpaRepository<StatusOrder, Integer> {

	Optional<StatusOrder> findByIdStatusOrder(Integer idStatusOrder);
	
	
	
}
