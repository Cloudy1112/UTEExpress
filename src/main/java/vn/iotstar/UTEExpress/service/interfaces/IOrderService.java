package vn.iotstar.UTEExpress.service.interfaces;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.UTEExpress.entity.Order;

public interface IOrderService {
	Optional<Order> findByOrderDate(Date date);

	Optional<Order> findByStatus(Integer status);

	Optional<Order> findByIDShipper(String IDShipper);

	Optional<Order> findByIDTransport(String IDTransport);

	Optional<Order> findByIDGoods(String IDGoods);

	Optional<Order> findByIDUser(String IDUser);

	Optional<Order> findByIDVoucher(String IDVoucher);

	Optional<Order> findByIDPost(String IDPost);

	public Page<Order> findByIDOrder(String id, Pageable pageable);

	public Page<Order> findByStatus(Integer status, Pageable pageable);
	
	void createOrder(Order order);
	
	void updateOrder(Order order);
	
	void cancelOrder(String IDOrder);
	
	void updateStatusOrder(String IDOrder, Integer status, Date dateUpdate);
	
	void addVouchertoOrder(String IDOrder, String IDVoucher );
	
}
