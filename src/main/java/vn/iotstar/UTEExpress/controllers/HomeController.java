package vn.iotstar.UTEExpress.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping("track-order")
	public String trackOrder(Model model) {
		model.addAttribute("status", 5);
		return "home/tracking-order";
	}
	
}
