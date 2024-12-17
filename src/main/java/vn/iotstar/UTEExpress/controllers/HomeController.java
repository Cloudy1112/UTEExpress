package vn.iotstar.UTEExpress.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.StatusOrder;
import vn.iotstar.UTEExpress.service.impl.OrderServiceImpl;
import vn.iotstar.UTEExpress.service.impl.StatusOrderServiceImpl;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private StatusOrderServiceImpl statusOrderService;
	
	@GetMapping("track-order")
	public String trackOrder(Model model, HttpServletRequest request) {
		Order order = orderService.findByID("1xxx1");
		model.addAttribute("order", order);
		List<StatusOrder> allStatuses = statusOrderService.findAll();
		model.addAttribute("allStatuses", allStatuses);
		model.addAttribute("formattedTotal", String.format("%.2f", order.getTotal()));
		
		return "home/tracking-order";
	}
	
	@GetMapping("")
	public String home() {
		return "home/index";
	}
	
}
