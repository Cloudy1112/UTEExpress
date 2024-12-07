package vn.iotstar.UTEExpress.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Post;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

	Optional<Order> findByOrderDate(Date date);

	Optional<Order> findByStatus(Integer status);

	Optional<Order> findByShipper_IDShipper(String IDShipper);

	Optional<Order> findByTransport_IDTransport(String IDTransport);

	Optional<Order> findByGood_IDGoods(String IDGoods);

	Optional<Order> findByUser_IDUser(String IDUser);

	Optional<Order> findByVoucher_IDVoucher(String IDVoucher);

	Optional<Order> findByPostOffice_IDPost(String IDPost);

	Page<Order> findByIDOrder(String IDOrder, Pageable pageable);

	Page<Order> findByStatus(Integer status, Pageable pageable);

}