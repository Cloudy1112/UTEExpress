package vn.iotstar.UTEExpress.controllers.shipper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.service.interfaces.IOrderService;
import vn.iotstar.UTEExpress.service.interfaces.IShipperService;
@Controller
public class ShipperStatusOrderController {
	 	@Autowired
	    IShipperService shipperService;

	    @Autowired
	    IOrderService orderService;

	    @GetMapping("/shipper/shipper-statistics")
	    public String getShipperStatistics(Model model) {
	     // Giả sử shipperID đã được truyền từ frontend hoặc lấy từ session
	    String shipperID = "someShipperId"; // Cần thay bằng ID thật

	        // Lấy shipper từ dịch vụ
	    Shipper shipper = shipperService.findByID(shipperID).orElse(null);
	        if (shipper == null) {
	            return "error"; // Nếu không tìm thấy shipper
	        }

	        // Lấy danh sách đơn hàng của shipper
	        List<Order> orders = orderService.filterOrderByPostID(shipperID);
	        
	        // Tính toán số lượng đơn hàng theo trạng thái
	        long pendingOrdersCount = orders.stream().filter(order -> order.getStatus() == 0).count();
	        long deliveredOrdersCount = orders.stream().filter(order -> order.getStatus() == 7).count();
	        long failedOrdersCount = orders.stream().filter(order -> order.getStatus() == 8).count();

	        // Thêm thông tin vào model
	       // model.addAttribute("shipper", shipper);
	        model.addAttribute("orders", orders);
	        model.addAttribute("pendingOrdersCount", pendingOrdersCount);
	        model.addAttribute("deliveredOrdersCount", deliveredOrdersCount);
	        model.addAttribute("failedOrdersCount", failedOrdersCount);
	        model.addAttribute("totalOrders", orders.size());

	        return "shipperStatistics"; // Tên view thymeleaf
	   }
}
