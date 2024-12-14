package vn.iotstar.UTEExpress.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.UTEExpress.entity.Transport;

public interface ITransportRepository extends JpaRepository<Transport, Integer> {
	
	  Transport findByTransportType(String transportType);
	
}
