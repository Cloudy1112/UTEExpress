package vn.iotstar.UTEExpress.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin/{id}/statistic")
public class AdminStatistic {
	
	@GetMapping("/shipFee")
	public String shipFee(@RequestParam String param) {
		return new String();
	}
	
	@GetMapping("/codsurcharge")
	public String codSurcharge(@RequestParam String param) {
		return new String();
	}
	
	
}
