package vn.iotstar.UTEExpress.controllers.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import vn.iotstar.UTEExpress.entity.Account;
import vn.iotstar.UTEExpress.entity.Manager;
import vn.iotstar.UTEExpress.service.IAccountService;
import vn.iotstar.UTEExpress.service.ICustomerService;
import vn.iotstar.UTEExpress.service.IManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerControler {
	@Autowired
	private IManagerService managerService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private PasswordEncoder encoder;
	
	// login xong sẽ về trang này nếu role là manager
	@GetMapping("/{id}")
	public String managerHome(@PathVariable("id") Integer managerID, Model model) {
		// find manager by id
		Manager manager = managerService.findById(managerID).get();
		// truyền model lên views
		model.addAttribute("manager", manager);
		return "manager/home";
	}
	
	@GetMapping("/{id}/manager-info")
	public String managerDetailsInfo(@PathVariable("id") Integer managerID, Model model) {
		// find manager by id
		Manager manager = managerService.findById(managerID).get();
//		if(manager != null) System.out.println("khac null");
		// truyền model lên views
		model.addAttribute("manager", manager);
		
		return "manager/account-info";
	}
	
	@PostMapping("/{id}/manager-info")
	public String updateManagerInfo(@PathVariable("id") Integer managerID, HttpServletRequest request, @ModelAttribute("manager") Manager manager) {
		String name = request.getParameter("name");
	    Integer gender = Integer.parseInt(request.getParameter("gender"));
	    String birthString = request.getParameter("birth");
	 
	    String address = request.getParameter("address");
	    String phone = request.getParameter("phone");
	    String cccd = request.getParameter("cccd");
	    String oldPassword = request.getParameter("oldPassword");
	    String newPassword = request.getParameter("newPassword");
	    String confirmPassword = request.getParameter("confirmPassword");
	    
	    Manager oldManager = managerService.findById(managerID).get();
	    if(!encoder.matches(oldPassword,oldManager.getAccount().getPassword())) {  // sửa
	    	return "redirect:/manager/" + managerID + "/manager-info?status=wrong-pass";
	    } else if(!newPassword.equals(confirmPassword)) {   
	    	return "redirect:/manager/" + managerID + "/manager-info?status=missmatch";
	    }
	    oldManager.setName(name);
	    oldManager.setGender(gender);
	    oldManager.setAddress(address);
	    oldManager.setPassword(encoder.encode(confirmPassword));
	    oldManager.setPhone(phone);
	    oldManager.setCccd(cccd);
	    
	 // htem
	    Account account = oldManager.getAccount();
	    account.setPassword(confirmPassword);
	    accountService.save(account);
	    
	    // Manually parse the birth string to Date
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date birthDate = null;
	    try {
	        birthDate = dateFormat.parse(birthString);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "redirect:/manager/" + managerID + "/manager-info?status=invalid-birth-date"; // Handle invalid date
	    }
	    oldManager.setBirth(birthDate);
	    //save
	    try {
			managerService.save(oldManager);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    return "redirect:/manager/" + managerID + "/manager-info?status=success";
	}
	
}
