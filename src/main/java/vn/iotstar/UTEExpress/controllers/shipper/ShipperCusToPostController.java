package vn.iotstar.UTEExpress.controllers.shipper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import vn.iotstar.UTEExpress.entity.Account;
import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.entity.Shipping;
import vn.iotstar.UTEExpress.service.IAccountService;
import vn.iotstar.UTEExpress.service.IOrderService;
import vn.iotstar.UTEExpress.service.IShipperService;
import vn.iotstar.UTEExpress.service.impl.ShippingServiceImpl;

@Controller
@RequestMapping("/shippercustopost/{id}")
public class ShipperCusToPostController {
	@Autowired
	private IShipperService shipperService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private ShippingServiceImpl shippingService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("")
	public String homeCusToPost(@PathVariable("id") Integer shipperID, Model model) {
		
		Shipper shipper = shipperService.findById(shipperID).get();
		model.addAttribute("shipper",shipper);
		
		return "shipper/custopost-home";
	}
	
	@GetMapping("/account-info")
	public String accountInfoView(@PathVariable("id") Integer shipperID, Model model) {
		Shipper shipper = shipperService.findById(shipperID).get();
		model.addAttribute("shipper", shipper);
		return "shipper/custopost-account-info";
	}
	
	@PostMapping("/account-info")
	public String updateAccountInfo(@PathVariable("id") Integer shipperID, Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
	    Integer gender = Integer.parseInt(request.getParameter("gender"));
	    String birthString = request.getParameter("birth");
	 
	    String address = request.getParameter("address");
	    String phone = request.getParameter("phone");
	    String cccd = request.getParameter("cccd");
	    String oldPassword = request.getParameter("oldPassword");
	    String newPassword = request.getParameter("newPassword");
	    String confirmPassword = request.getParameter("confirmPassword");
	    
	    Shipper oldShipper = shipperService.findById(shipperID).get();
	    if(!encoder.matches(oldPassword, oldShipper.getPassword())) {
	    	return "redirect:/shippercustopost/" + shipperID + "/account-info?status=wrong-pass";
	    } else if(!newPassword.equals(confirmPassword)) {
	    	return "redirect:/shippercustopost/" + shipperID + "/account-info?status=missmatch";
	    }
	    oldShipper.setName(name);
	    oldShipper.setGender(gender);
	    oldShipper.setAddress(address);
	    oldShipper.setPassword(encoder.encode(newPassword));
	    oldShipper.setPhone(phone);
	    oldShipper.setCccd(cccd);
	    
	 // htem
	    Account account = oldShipper.getAccount();
	    account.setPassword(confirmPassword);
	    accountService.save(account);
	    
	    // Manually parse the birth string to Date
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date birthDate = null;
	    try {
	        birthDate = dateFormat.parse(birthString);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "redirect:/shippercustopost/" + shipperID + "/account-info?status=invalid-birth-date"; // Handle invalid date
	    }
	    oldShipper.setBirth(birthDate);
	    //save
	    try {
			shipperService.save(oldShipper);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    return "redirect:/shippercustopost/" + shipperID + "/account-info?status=success";
	}
	
	@GetMapping("/shipments")
	public String getShipmentsView(@PathVariable("id") Integer shipperID, Model model) {
		
		Shipper shipper = shipperService.findById(shipperID).get();
		model.addAttribute("shipper", shipper);
		
		// shipment take
		List<Order> allShipmentsTake = orderService.findOrdersByShipperIDAndStatus(shipperID, 1);
		model.addAttribute("allShipmentsTake", allShipmentsTake);
		// --> sau này lên trạng thái la 2
		
		// inprogress
		List<Order> allShipmentsInProgress = orderService.findOrdersByShipperIDAndStatus(shipperID, 2);
		model.addAttribute("allShipmentsInProgress", allShipmentsInProgress);
		// --> lên trạng thái la 4 -> xóa shipper tren shipping
		
		// failed
		List<Order> allShipmentsFailed = orderService.findOrdersByShipperIDAndStatus(shipperID, 9);
		model.addAttribute("allShipmentsFailed", allShipmentsFailed);
		// --> lên trạng thái la 9
		
		return "shipper/custopost-shipment";
	}
	
	@GetMapping("take-shipment")
	public String takingShipmentCusToPost(@PathVariable("id") Integer shipperID, @RequestParam("orderid") String orderID) {
		System.out.println("called");
		// --> sau này lên trạng thái la 2
		Shipper shipper = shipperService.findById(shipperID).get();
		
		Shipping shipping = shippingService.findByOrderID(orderID);
		shipping.setStatusOrderID(2);
		shippingService.save(shipping);
		
		return "redirect:/shippercustopost/" + shipperID + "/shipments";
	}
	
	@GetMapping("success-shipment")
	public String successTakingShipmentFrCusToPost(@PathVariable("id") Integer shipperID, @RequestParam("orderid") String orderID) {
		System.out.println("called");
		
		// --> lên trạng thái la 4 -> xóa shipper tren shipping
		Shipper shipper = shipperService.findById(shipperID).get();
		
		Shipping shipping = shippingService.findByOrderID(orderID);
		shipping.setStatusOrderID(4);
		shipping.setShipper(null);
		shippingService.save(shipping);
		
		return "redirect:/shippercustopost/" + shipperID + "/shipments";
	}
	
	@GetMapping("failed-shipment")
	public String failedTakingShipmentFrCusToPost(@PathVariable("id") Integer shipperID, @RequestParam("orderid") String orderID) {
		System.out.println("called");
		
		// --> lên trạng thái la 9
		Shipper shipper = shipperService.findById(shipperID).get();
		
		Shipping shipping = shippingService.findByOrderID(orderID);
		shipping.setStatusOrderID(9);
		shippingService.save(shipping);
				
		return "redirect:/shippercustopost/" + shipperID + "/shipments";
	}
}
