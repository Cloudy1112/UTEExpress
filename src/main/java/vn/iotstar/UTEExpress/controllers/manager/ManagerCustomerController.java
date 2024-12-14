package vn.iotstar.UTEExpress.controllers.manager;

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

import vn.iotstar.UTEExpress.entity.Customer;
import vn.iotstar.UTEExpress.entity.Manager;
import vn.iotstar.UTEExpress.service.ICustomerService;
import vn.iotstar.UTEExpress.service.impl.ManagerServiceImpl;


@Controller
@RequestMapping("/manager/{id}/")
public class ManagerCustomerController {
	@Autowired
	private ManagerServiceImpl managerService;
	@Autowired
	private ICustomerService customerService;
	
	// trang co list cac customer thuoc buu cuc (dua tren city)
	@GetMapping("customer-request")
	public String customerRequestViews(Model model, @PathVariable("id") Integer managerID) {
		// find manager by id
		Manager manager = managerService.findById(managerID).get();
		model.addAttribute("manager", manager);
		List<Customer> customers = customerService.findInactiveCustomersByCity(manager.getPost().getCity().getCityName());
		model.addAttribute("requestCustomers", customers);

		return "manager/customer-request";	
	}
	
	/*
	 * chuyển về trang co list cac customer thuoc buu cuc (dua tren city) cho phep
	 * dang ki chuyen isActive thanh 1 tro ve home
	 */
	@GetMapping("active-customer")
	public String permitCustomerRequest(@PathVariable("id") Integer managerID, @RequestParam("username") String username) {
		Customer customer = customerService.findCustomerByUserName(username);
		customer.setIsActive(1);
		
		customerService.save(customer);
		
		return "redirect:/manager/" + managerID + "/customer-request";
	}
	

}
