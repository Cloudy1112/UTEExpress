package vn.iotstar.UTEExpress.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import vn.iotstar.UTEExpress.entity.Account;
import vn.iotstar.UTEExpress.entity.Customer;
import vn.iotstar.UTEExpress.entity.Role;
import vn.iotstar.UTEExpress.service.impl.AccountServiceImpl;
import vn.iotstar.UTEExpress.service.impl.CustomerServiceImpl;
import vn.iotstar.UTEExpress.service.impl.RoleServiceImpl;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private CustomerServiceImpl customerService;
	@Autowired
	private RoleServiceImpl roleService;
	@Autowired
	private AccountServiceImpl accountService;
	
	@PostMapping("")
	public String processRegister(HttpServletRequest request) {
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String city = request.getParameter("city");
		
		//tạo customer mới
		Customer newCustomer = new Customer();
		newCustomer.setIsActive(0);
		newCustomer.setCity(city);
		newCustomer.setName(fullname);
		newCustomer.setPassword(password);
		
		Role role = roleService.findRoleByRoleNameIgnoreCase("CUSTOMER");
		Account newAccount = new Account();
		newAccount.setRole(role);
		newAccount.setUsername(username);
		newAccount.setPassword(password);
		accountService.save(newAccount);
		
		newCustomer.setAccount(newAccount);
		customerService.save(newCustomer);
		
		return "redirect:/login";
	}
}
