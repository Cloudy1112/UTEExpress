package vn.iotstar.UTEExpress.controllers.customer;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.iotstar.UTEExpress.entity.User;
import vn.iotstar.UTEExpress.service.impl.UserService;

@Controller

public class CustomerCotroller {
		@RequestMapping("/customer")
		 public String customer(){
			 
			 return "customer/profile.html";
		 }

}
