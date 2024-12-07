package vn.iotstar.UTEExpress.service.impl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Voucher;
import vn.iotstar.UTEExpress.model.VoucherModel;
import vn.iotstar.UTEExpress.repository.OrderRepository;
import vn.iotstar.UTEExpress.repository.VoucherRepository;
import vn.iotstar.UTEExpress.service.interfaces.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	VoucherRepository voucherRepository;
	
	@Autowired
	VoucherService voucherService;

	@Override
	public Optional<Order> findByOrderDate(Date date) {
		// TODO Auto-generated method stub
		return orderRepository.findByOrderDate(date);
	}

	@Override
	public Optional<Order> findByStatus(Integer status) {
		// TODO Auto-generated method stub
		return orderRepository.findByStatus(status);
	}

	@Override
	public Optional<Order> findByIDShipper(String IDShipper) {
		// TODO Auto-generated method stub
		return orderRepository.findByShipper_IDShipper(IDShipper);
	}

	@Override
	public Optional<Order> findByIDTransport(String IDTransport) {
		// TODO Auto-generated method stub
		return orderRepository.findByTransport_IDTransport(IDTransport);
	}

	@Override
	public Optional<Order> findByIDGoods(String IDGoods) {
		// TODO Auto-generated method stub
		return orderRepository.findByGood_IDGoods(IDGoods);
	}

	@Override
	public Optional<Order> findByIDUser(String IDUser) {
		// TODO Auto-generated method stub
		return orderRepository.findByUser_IDUser(IDUser);
	}

	@Override
	public Optional<Order> findByIDVoucher(String IDVoucher) {
		// TODO Auto-generated method stub
		return orderRepository.findByVoucher_IDVoucher(IDVoucher);
	}

	@Override
	public Optional<Order> findByIDPost(String IDPost) {
		// TODO Auto-generated method stub
		return orderRepository.findByPostOffice_IDPost(IDPost);
	}

	@Override
	public Page<Order> findByIDOrder(String id, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderRepository.findByIDOrder(id, pageable);
	}

	@Override
	public Page<Order> findByStatus(Integer status, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderRepository.findByStatus(status, pageable);
	}

	@Override
	public void createOrder(Order order) {
		Order orderBefore = new Order();

		orderBefore.setDest(order.getDest());
		orderBefore.setDestCity(order.getDestCity());
		orderBefore.setSource(order.getSource());
		orderBefore.setSourceCity(order.getSourceCity());

		orderBefore.setHeight(order.getHeight());
		orderBefore.setWeigth(order.getWeigth());
		orderBefore.setWidth(order.getWidth());

		orderBefore.setGood(order.getGood());
		orderBefore.setOrderDate(order.getOrderDate());
		orderBefore.setPostOffice(order.getPostOffice());

		orderBefore.setShipper(order.getShipper());

		orderBefore.setStatus(order.getStatus());
		orderBefore.setTransport(order.getTransport());
		orderBefore.setUser(order.getUser());

		if (order.getVoucher() != null) {
			Voucher voucher = voucherRepository.findById(order.getVoucher().getIDVoucher()).orElse(null);
			voucherService.reduceVoucher(voucher);	//Giam so luong voucher
			
			orderBefore.setVoucher(order.getVoucher());
		}

		orderBefore.setShipFee(order.getShipFee());
		orderBefore.setCodFee(order.getCodFee()); // Tien Cod nguoi gui se nhap so tien se thu

		orderRepository.save(orderBefore);
	}

	@Override
	public void updateOrder(Order order) {
		Order orderBefore = orderRepository.findById(order.getIDOrder())
				.orElseThrow(() -> new RuntimeException("Order not found"));

		orderBefore.setDest(order.getDest());
		orderBefore.setDestCity(order.getDestCity());
		orderBefore.setSource(order.getSource());
		orderBefore.setSourceCity(order.getSourceCity());

		orderBefore.setHeight(order.getHeight());
		orderBefore.setWeigth(order.getWeigth());
		orderBefore.setWidth(order.getWidth());

		orderBefore.setGood(order.getGood());
		orderBefore.setOrderDate(order.getOrderDate());
		orderBefore.setPostOffice(order.getPostOffice());

		orderBefore.setShipper(order.getShipper());

		orderBefore.setStatus(order.getStatus());
		orderBefore.setTransport(order.getTransport());
		orderBefore.setUser(order.getUser());

		if (order.getVoucher() != null) {
			Voucher voucherOld = voucherRepository.findById(orderBefore.getVoucher().getIDVoucher()).orElse(null); //Tìm voucher đã áp dụng trong đơn hàng CŨ
			Voucher voucherNew = voucherRepository.findById(order.getVoucher().getIDVoucher()).orElse(null); //Tìm voucher đã áp dụng trong đơn hàng MỚI
			
			//Trường hợp nếu người dùng đổi Voucher
			if (voucherOld.getIDVoucher() != voucherNew.getIDVoucher() ) { //Nếu voucher trong order mới khác với voucher áp dụng cho đơn hàng cũ
				
				voucherService.increaseVoucher(voucherOld);	//Tăng lại số lượng Voucher cũ
				
				voucherService.reduceVoucher(voucherNew); //Giảm số lượng Voucher mới
			}
			
			orderBefore.setVoucher(order.getVoucher()); //Gán lại Voucher cho đơn hàng
				
		}

		orderBefore.setShipFee(order.getShipFee());
		orderBefore.setCodFee(order.getCodFee()); // Tien Cod nguoi gui se nhap so tien se thu

		orderRepository.save(orderBefore);

	}

	@Override
	public void cancelOrder(String IDOrder) {
		Order orderBefore = orderRepository.findById(IDOrder)
				.orElseThrow(() -> new RuntimeException("Order not found"));
		
		if (orderBefore.getVoucher().getIDVoucher() != null) { 
			//Đây là trường hợp Đơn huỷ có áp dụng Voucher
			//Nên khi xoá đơn cần tăng lại số lượng Voucher			
			Voucher voucher = voucherRepository.findById(orderBefore.getVoucher().getIDVoucher()).orElse(null); 	//Tìm voucher của Order cũ
			voucherService.increaseVoucher(voucher);	//Tăng lại số lương Voucher
		}
		
		orderRepository.deleteById(IDOrder);

	}

	@Override
	public void updateStatusOrder(String IDOrder, Integer status, Date dateUpdate) {
		// Chức năng sẽ được dùng bởi User (0 Pending, 2 Cancelled )
		//Chức năng sẽ được dùng bởi Manager (1 Confirmed, 3 Shipping )
		//Chức năng sẽ 

	}

	@Override
	public void addVouchertoOrder(String IDOrder, String IDVoucher) {
		// TODO Auto-generated method stub

	}

}
