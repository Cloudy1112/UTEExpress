package vn.iotstar.UTEExpress.controllers.customer;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import vn.iotstar.UTEExpress.dto.OrderDTO;
import vn.iotstar.UTEExpress.entity.City;
import vn.iotstar.UTEExpress.entity.Customer;
import vn.iotstar.UTEExpress.service.ICityService;
import vn.iotstar.UTEExpress.service.ICustomerService;
import vn.iotstar.UTEExpress.service.IOrderService;
import vn.iotstar.UTEExpress.service.IShippingService;
import vn.iotstar.UTEExpress.utils.ConstantUtils;
import vn.iotstar.UTEExpress.entity.Order;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	@Autowired
	ICityService cityService;
	@Autowired
	IOrderService orderService;
	@Autowired
	IShippingService shippingService;

	/*
	 * Khi người dùng vừa đăng nhập nó sẽ chuyển sang trang quản lý đơn hàng đầu
	 * tiên
	 */
	@GetMapping("/{id}")
	public String Order(@PathVariable("id") Integer customerID, Model model) {
		List<Order> orders = orderService.findAllByCustomerID(customerID);
		List<OrderDTO> orderDTO = new ArrayList<>();

		for (Order order : orders) {
			if (order.getCustomer().getCustomerID() == customerID) {
				OrderDTO dto = new OrderDTO();
				dto.setOrderID(order.getOrderID());
				dto.setWeight(order.getWeight());
				dto.setHeight(order.getHeight());
				dto.setWidth(order.getWidth());
				dto.setSourceCity(order.getSourceCity());
				dto.setDestCity(order.getDestCity());
				dto.setSource(order.getSource());
				dto.setDest(order.getDest());
				dto.setNameReceiver(order.getNameReceiver());
				dto.setPhoneReceiver(order.getPhoneReceiver());
				dto.setCodFee(order.getCodFee());
				dto.setShipFee(order.getShipFee());
				dto.setVoucherName(order.getVoucher() != null ? order.getVoucher().getVoucherName() : null);
				dto.setGoodsType(order.getGoods() != null ? order.getGoods().getGoodsType() : null);
				dto.setTransportType(order.getTransport() != null ? order.getTransport().getTransportType() : null);
				dto.setCOD_surcharge(order.getCodFee()*0.1);
				dto.setTotal(order.getTotal());
				dto.setStatusOrderID(shippingService.findNewStatusOrderByOrderID(order.getOrderID())); 
				orderDTO.add(dto);
			}
		}

		// show thong tin don hang
		model.addAttribute("orders", orderDTO);
		model.addAttribute("id", customerID);
		return "customer/home";
	}

}
