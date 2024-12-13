package vn.iotstar.UTEExpress.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.UTEExpress.entity.Manager;
import vn.iotstar.UTEExpress.service.impl.ManagerServiceImpl;
import vn.iotstar.UTEExpress.service.impl.OrderServiceImpl;

@Controller
@RequestMapping("/manager/{id}/")
public class ManagerOrderController {
	@Autowired
	private ManagerServiceImpl managerService;
	@Autowired
	private OrderServiceImpl orderService;
	
	public String allOrderOfPost(@PathVariable("id") Integer managerID, Model model) {
		Manager manager = managerService.findById(managerID).get();
		
		model.addAttribute("manager",manager);
		
		// order co kieu giao hàng tiết kiệm 
		
		// order co kieu giao hàng nhanh
		
		// order co kieu giao hàng hỏa tốc
		
		
		return "manager/order";
	}

}
