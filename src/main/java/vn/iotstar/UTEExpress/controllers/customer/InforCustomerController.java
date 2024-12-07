package vn.iotstar.UTEExpress.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.UTEExpress.service.interfaces.IUserService;

@Controller
@RequestMapping("/customer")
public class InforCustomerController {
	@Autowired
	IUserService userService;
	

	
	
}
