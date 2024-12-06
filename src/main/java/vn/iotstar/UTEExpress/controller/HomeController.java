package vn.iotstar.UTEExpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	 @GetMapping("")	//Trang Home cua guest
	    public String index() {
	        return "index"; // Trả về tên file HTML (không cần phần mở rộng .html)
	 }
	 
	 @GetMapping("gioithieu")	//Trang Home cua guest
	    public String guestHome() {
	        return "gioithieu"; // Trả về tên file HTML (không cần phần mở rộng .html)
	 }
	 
	 @GetMapping("home/user")	//Trang Home cua user
	    public String userHome() {
	        return "user/home"; // Trả về tên file HTML (không cần phần mở rộng .html)
	 }
	 
	 @GetMapping("home/shipper")	//Trang Home cua shipper
	    public String shipperHome() {
	        return "shipper/home"; // Trả về tên file HTML (không cần phần mở rộng .html)
	 }
}
