package vn.iotstar.UTEExpress.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.UTEExpress.entity.Account;
import vn.iotstar.UTEExpress.entity.City;
import vn.iotstar.UTEExpress.entity.Customer;
import vn.iotstar.UTEExpress.entity.Manager;
import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.service.impl.AccountDetailService;
import vn.iotstar.UTEExpress.service.impl.AccountServiceImpl;
import vn.iotstar.UTEExpress.service.impl.CityServiceImpl;
import vn.iotstar.UTEExpress.service.impl.CustomerServiceImpl;
import vn.iotstar.UTEExpress.service.impl.ManagerServiceImpl;
import vn.iotstar.UTEExpress.service.impl.ShipperServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private CityServiceImpl cityService;
    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private ManagerServiceImpl managerService;
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private ShipperServiceImpl shipperService;

    @GetMapping("")
    public String loginViews(Model model, HttpServletRequest request) {
        // Kiểm tra session
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            Account account = (Account) session.getAttribute("account");
            return redirectBasedOnRole(account);
        }

        // Nếu chưa có session
        List<City> cities = cityService.findAll();
        model.addAttribute("allCity", cities);
        return "home/login"; // Trang đăng nhập
    }

    private String redirectBasedOnRole(Account account) {
        switch (account.getRole().getRoleID()) {
            case 2:
                return "redirect:/manager/" + managerService.findManagerByUsername(account.getUsername()).getManagerID();
            case 3:
                return "redirect:/customer/" + customerService.findCustomerByUserName(account.getUsername()).getCustomerID();
            case 4:
                return "redirect:/shippercustocus/" + shipperService.findShipperByUsername(account.getUsername()).getShipperID();
            case 5:
                return "redirect:/shippercustopost/" + shipperService.findShipperByUsername(account.getUsername()).getShipperID();
            case 6:
                return "redirect:/shipperposttocus/" + shipperService.findShipperByUsername(account.getUsername()).getShipperID();
            case 7:
                return "redirect:/shipperposttopost/" + shipperService.findShipperByUsername(account.getUsername()).getShipperID();
            default:
                return "redirect:/home"; // Mặc định nếu không có role phù hợp
        }
    }

    @GetMapping("/waiting")
    public String processLogin(HttpServletRequest request) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName(); // Lấy username

        Account account = accountService.findById(username).get();

        if (account == null || account.getRole() == null) {
            return "redirect:/login?error=account-doesnt-exist";
        }

        // Lưu thông tin vào session
        HttpSession session = request.getSession();
        session.setAttribute("account", account);

        // Điều hướng dựa trên vai trò
        return redirectBasedOnRole(account);
    }
}
