package vn.iotstar.UTEExpress.controllers.shipper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.service.impl.ShipperServiceImpl;

@Controller
@RequestMapping("/shipper/order")
public class ShipperOrderController {
	@Autowired
	ShipperServiceImpl shipperService;
	
	@GetMapping("delivered/{id}")
	public String MarkDelivered(@PathVariable("id") String IDOrder) {
		shipperService.editStatusOrder(IDOrder, 4);
		
		Order order = shipperService.findOrderByIDOrder(IDOrder).get();
		
		return "redirect:/shipper/"+ order.getShipper().IDShipper;
	}
	
	@GetMapping("failed/{id}")
	public String MarkFailed(@PathVariable("id") String IDOrder) {
		shipperService.editStatusOrder(IDOrder, 5);
		
		Order order = shipperService.findOrderByIDOrder(IDOrder).get();
		return "redirect:/shipper/"+ order.getShipper().IDShipper;
	}
	
	@GetMapping("shipping/{id}")
	public String MarkShipping(@PathVariable("id") String IDOrder) {
		shipperService.editStatusOrder(IDOrder, 3);
		
		Order order = shipperService.findOrderByIDOrder(IDOrder).get();
		
		return "redirect:/shipper/"+ order.getShipper().IDShipper;
	}
	

}
