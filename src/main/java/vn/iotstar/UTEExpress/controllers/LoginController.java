package vn.iotstar.UTEExpress.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.UTEExpress.entity.City;
import vn.iotstar.UTEExpress.repository.ICityRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private ICityRepository cityRepository;
	@GetMapping("")
	public String loginViews(Model model) {
		List<City> city = cityRepository.findAll();
		model.addAttribute("allCity", city);
		
		return "home/login";
	}
}
