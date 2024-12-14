package vn.iotstar.UTEExpress.controllers.shipper;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Transport;
import vn.iotstar.UTEExpress.service.impl.OrderServiceImpl;
import vn.iotstar.UTEExpress.service.impl.ShipperServiceImpl;
import vn.iotstar.UTEExpress.service.impl.TransportServiceImpl;

@Controller
@RequestMapping("/shipper/order")
public class ShipperOrderController {
	@Autowired
	ShipperServiceImpl shipperService;
	  @Autowired
	TransportServiceImpl transportService;
	  @Autowired
	 OrderServiceImpl orderService;
	
	  @GetMapping("/express-orders")
	    public String getExpressOrders(Model model) {
	        List<Order> expressOrders = orderService.getOrdersByTransportType("Express");
	        model.addAttribute("orders", expressOrders);
	        return "express-orders";
	    }

	    @GetMapping("/create-express-order")
	    public String createExpressOrderForm(Model model) {
	        Transport expressTransport = transportService.getTransportByType("Express");
	        model.addAttribute("transport", expressTransport);
	        return "create-express-order";
	    }

	    @PostMapping("/create-express-order")
	    public String createExpressOrder(
	        @RequestParam("weight") Integer weight,
	        @RequestParam("height") Integer height,
	        @RequestParam("width") Integer width,
	        @RequestParam("sourceCity") String sourceCity,
	        @RequestParam("destCity") String destCity,
	        @RequestParam("source") String source,
	        @RequestParam("dest") String dest,
	        @RequestParam("codFee") Integer codFee,
	        @RequestParam("shipFee") Integer shipFee
	    ) {
	        Transport expressTransport = transportService.getTransportByType("Express");

	        Order order = new Order();
	        order.setWeight(weight);
	        order.setHeight(height);
	        order.setWidth(width);
	        order.setSourceCity(sourceCity);
	        order.setDestCity(destCity);
	        order.setSource(source);
	        order.setDest(dest);
	        order.setCodFee(codFee);
	        order.setShipFee(shipFee);
	        order.setTransport(expressTransport);
	        order.setStatus(1); // Đơn hàng mới tạo

	        orderService.saveOrder(order);
	        return "redirect:/express-orders";
	    }
}
