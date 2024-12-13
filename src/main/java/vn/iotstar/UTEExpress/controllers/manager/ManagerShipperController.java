package vn.iotstar.UTEExpress.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.UTEExpress.entity.Manager;
import vn.iotstar.UTEExpress.service.impl.ManagerServiceImpl;
import vn.iotstar.UTEExpress.service.impl.ShipperServiceImpl;

@Controller
@RequestMapping("/manager/{id}/")
public class ManagerShipperController {
	@Autowired
	private ManagerServiceImpl managerService;
	@Autowired
	private ShipperServiceImpl shipperService;
	
	@GetMapping("shippers")
	public String listShippers(@PathVariable("id") Integer managerID, Model model) {
		Manager manager = managerService.findById(managerID).get();
		model.addAttribute("manager",manager);
		return "";
	}
}
