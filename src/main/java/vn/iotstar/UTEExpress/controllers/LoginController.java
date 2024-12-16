package vn.iotstar.UTEExpress.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.UTEExpress.entity.Account;
import vn.iotstar.UTEExpress.entity.City;
import vn.iotstar.UTEExpress.entity.Customer;
import vn.iotstar.UTEExpress.entity.Manager;
import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.service.impl.AccountServiceImpl;
import vn.iotstar.UTEExpress.service.impl.CityServiceImpl;
import vn.iotstar.UTEExpress.service.impl.CustomerServiceImpl;
import vn.iotstar.UTEExpress.service.impl.ManagerServiceImpl;
import vn.iotstar.UTEExpress.service.impl.ShipperServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private CityServiceImpl cityService;
	@Autowired
	private AccountServiceImpl accountService;
	@Autowired
	private ManagerServiceImpl managerService;
	@Autowired
	private CustomerServiceImpl customerService;
	@Autowired
	private ShipperServiceImpl shipperService;
	
	
	@GetMapping("")
	public String loginViews(Model model, HttpServletRequest request) {
		// kiểm tra session
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			Account account = (Account) session.getAttribute("account");
			if (account.getRole().getRoleID() == 2) {
		        Manager manager = managerService.findManagerByUsername(account.getUsername());
		        return "redirect:/manager/" + manager.getManagerID();
		    } 
		    // Kiểm tra tài khoản của Customer
		    else if (account.getRole().getRoleID() == 3) {
		        Customer customer = customerService.findCustomerByUserName(account.getUsername());
		        return "redirect:/customer/" + customer.getCustomerID();
		    } 
		    else if (account.getRole().getRoleID() == 4) {
		        Shipper shipper = shipperService.findShipperByUsername(account.getUsername());
		        return "redirect:/shippercustocus/" + shipper.getShipperID();
		    }
		    else if (account.getRole().getRoleID() == 5) {
		        Shipper shipper = shipperService.findShipperByUsername(account.getUsername());
		        return "redirect:/shippercustopost/" + shipper.getShipperID();
		    }
		    else if (account.getRole().getRoleID() == 6) {
		        Shipper shipper = shipperService.findShipperByUsername(account.getUsername());
		        return "redirect:/shipperposttocus/" + shipper.getShipperID();
		    }
		    else if (account.getRole().getRoleID() == 7) {
		        Shipper shipper = shipperService.findShipperByUsername(account.getUsername());
		        return "redirect:/shipperposttopost/" + shipper.getShipperID();
		    }
		}
		 
		// nếu chưa có session
		List<City> city = cityService.findAll();
		model.addAttribute("allCity", city);
		return "home/login";
	}
	
	@PostMapping("")
	public String processLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Account account = accountService.findById(username).get();
		
		if(account == null) {
			return "redirect:/login?error=account-doesnt-exist";
		} else {
			if(account.getRole() == null) {
				return "redirect:/login?error=account-doesnt-exist";
			}
		}
		
		// Khai báo session
	    HttpSession session = request.getSession(); 
	 
	    if (account.getRole().getRoleID() == 2 && account.getPassword().equals(password)) {
	        session.setAttribute("account", account);
	        Manager manager = managerService.findManagerByUsername(username);
	        
	        return "redirect:/manager/" + manager.getManagerID();
	    } 
	    // Kiểm tra tài khoản của Customer
	    else if (account.getRole().getRoleID() == 3 && account.getPassword().equals(password)) {
	        session.setAttribute("account", account);
	        Customer customer = customerService.findCustomerByUserName(username);
	        
	        return "redirect:/customer/" + customer.getCustomerID();
	    } 
	    else if (account.getRole().getRoleID() == 4 && account.getPassword().equals(password)) {
	        session.setAttribute("account", account);
	        
	        Shipper shipper = shipperService.findShipperByUsername(username);
	        return "redirect:/shippercustocus/" + shipper.getShipperID();
	    }
	    else if (account.getRole().getRoleID() == 5 && account.getPassword().equals(password)) {
	        session.setAttribute("account", account);
	        
	        Shipper shipper = shipperService.findShipperByUsername(username);
	        return "redirect:/shippercustopost/" + shipper.getShipperID();
	    }
	    else if (account.getRole().getRoleID() == 6 && account.getPassword().equals(password)) {
	        session.setAttribute("account", account);
	        
	        Shipper shipper = shipperService.findShipperByUsername(username);
	        return "redirect:/shipperposttocus/" + shipper.getShipperID();
	    }
	    else if (account.getRole().getRoleID() == 7 && account.getPassword().equals(password)) {
	        session.setAttribute("account", account);
	        
	        Shipper shipper = shipperService.findShipperByUsername(username);
	        return "redirect:/shipperposttopost/" + shipper.getShipperID();
	    }
	    else {
	        // Xóa session nếu thông tin không hợp lệ
	        session.invalidate();
	        return "redirect:/login?error=true";
	    }

	}
}
