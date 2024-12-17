package vn.iotstar.UTEExpress.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import vn.iotstar.UTEExpress.entity.Account;
import vn.iotstar.UTEExpress.entity.Customer;
import vn.iotstar.UTEExpress.entity.Role;
import vn.iotstar.UTEExpress.service.impl.AccountServiceImpl;
import vn.iotstar.UTEExpress.service.impl.CustomerServiceImpl;
import vn.iotstar.UTEExpress.service.impl.RoleServiceImpl;

@Controller
@RequestMapping("/register")
public class RegisterController {
    
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private PasswordEncoder encoder;
    
    @PostMapping("")
    public String processRegister(HttpServletRequest request) {
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String city = request.getParameter("city");
        
        // Check if the username already exists
        if (accountService.findById(username).isPresent()) {
            return "redirect:/register?error=username-already-exists";
        }
        
        // Create a new Customer
        Customer newCustomer = new Customer();
        newCustomer.setIsActive(0); // Default to inactive
        newCustomer.setCity(city);
        newCustomer.setName(fullname);
        newCustomer.setPassword(encoder.encode(password));
        
        // Assign the "CUSTOMER" role
        Role role = roleService.findRoleByRoleNameIgnoreCase("CUSTOMER");
        
        // Create a new Account with an encoded password
        Account newAccount = new Account();
        newAccount.setRole(role);
        newAccount.setUsername(username);
        newAccount.setPassword(password);
        
        // Save the Account
        accountService.save(newAccount);
        
        // Link the Account to the Customer
        newCustomer.setAccount(newAccount);
        
        // Save the Customer
        customerService.save(newCustomer);
        
        return "redirect:/login";
    }

}
