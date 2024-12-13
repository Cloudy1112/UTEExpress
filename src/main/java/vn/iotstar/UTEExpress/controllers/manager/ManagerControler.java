package vn.iotstar.UTEExpress.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.UTEExpress.entity.Manager;
import vn.iotstar.UTEExpress.service.impl.ManagerServiceImpl;

@Controller
@RequestMapping("/manager")
public class ManagerControler {
	@Autowired
	private ManagerServiceImpl managerService;
	
	// login xong sẽ về trang này nếu role là manager
	@GetMapping("/{id}")
	public String managerHome(@PathVariable("id") Integer managerID, Model model) {
		// find manager by id
		Manager manager = managerService.findById(managerID).get();
		
		// truyền model lên views
		model.addAttribute("manager", manager);
		return "manager/home";
	}
	
}
