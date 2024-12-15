package vn.iotstar.UTEExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import vn.iotstar.UTEExpress.entity.StatusOrder;

public interface IStatusOrderRepository extends JpaRepository<StatusOrder, Integer> {
}
