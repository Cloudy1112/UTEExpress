package vn.iotstar.UTEExpress.controllers.customer;

import java.io.File;
import java.nio.file.Paths;

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
import vn.iotstar.UTEExpress.entity.City;
import vn.iotstar.UTEExpress.entity.Customer;
import vn.iotstar.UTEExpress.service.ICityService;
import vn.iotstar.UTEExpress.service.ICustomerService;
import vn.iotstar.UTEExpress.service.IOrderService;
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

	/*
	 * Khi người dùng vừa đăng nhập nó sẽ chuyển sang trang quản lý đơn hàng đầu
	 * tiên
	 */
	@GetMapping("/{id}")
	public String Order(@PathVariable("id") Integer customerID, Model model) {
		List<Order> orders = orderService.findAllByCustomerID(customerID);
		// show thong tin don hang
		model.addAttribute("id", customerID);
		return "customer/home";
	}

	

}
