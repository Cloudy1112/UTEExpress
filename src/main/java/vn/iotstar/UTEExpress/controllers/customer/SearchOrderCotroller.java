package vn.iotstar.UTEExpress.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import vn.iotstar.UTEExpress.service.interfaces.IOrderService;

@Controller
public class SearchOrderCotroller {
	@Autowired
	private IOrderService OrderService;
	
	
	public String searchOrder;
          
	
	
	

}
