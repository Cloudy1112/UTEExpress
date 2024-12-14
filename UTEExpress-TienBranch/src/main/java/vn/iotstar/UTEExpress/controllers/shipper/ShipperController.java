package vn.iotstar.UTEExpress.controllers.shipper;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.entity.Shipping;
import vn.iotstar.UTEExpress.service.impl.OrderServiceImpl;
import vn.iotstar.UTEExpress.service.impl.OrderStatusServiceImpl;
import vn.iotstar.UTEExpress.service.impl.ShipperServiceImpl;
import vn.iotstar.UTEExpress.utils.ConstantUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class ShipperController {
	@Autowired
	ShipperServiceImpl shipperService;
	
	@Autowired
	OrderServiceImpl orderService;
	
	@Autowired
	OrderStatusServiceImpl orderstatusService;
	
	 // ------------------- 1. LOGOUT -------------------
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }

    // ------------------- 2. SHIPPER HOME -------------------
    @GetMapping("/{id}")
    public String shipperHome(@PathVariable("id") String id, Model model) {
        Optional<Shipper> optionalShipper = shipperService.findByID(id);
        if (!optionalShipper.isPresent()) {
            return "redirect:/login";
        }
        Shipper shipper = optionalShipper.get();

        List<Order> ordersShipping = orderService.findByIdShipperAndStatus(id, 3); // Đơn đang giao
        List<Order> ordersFailed = orderService.findByIdShipperAndStatus(id, 5);  // Đơn thất bại
        List<Order> ordersDelivered = orderService.findByIdShipperAndStatus(id, 4); // Đơn thành công

        model.addAttribute("shipper", shipper);
        model.addAttribute("ordersShipping", ordersShipping);
        model.addAttribute("ordersFailed", ordersFailed);
        model.addAttribute("ordersDelivered", ordersDelivered);

        return "views/shipper/shipper-home";
    }

    // ------------------- 3. PROFILE -------------------
    @GetMapping("/profile/{id}")
    public String profile(@PathVariable("id") String id, Model model) {
        Optional<Shipper> optionalShipper = shipperService.findByID(id);
        if (!optionalShipper.isPresent()) {
            return "redirect:/login";
        }
		return id;

  
    }

    // ------------------- 4. EDIT PROFILE -------------------
    @GetMapping("/profile/edit/{id}")
    public String editProfile(@PathVariable("id") String idShipper, Model model) {
        Optional<Shipper> optionalShipper = shipperService.findByID(idShipper);
        if (!optionalShipper.isPresent()) {
            return "redirect:/login";
        }
        model.addAttribute("shipper", optionalShipper.get());
        return "views/shipper/editProfile";
    }

    // ------------------- 5. UPDATE PROFILE -------------------
    @PostMapping("/profile/update/{id}")
    public String updateProfile(
            @PathVariable("id") String idShipper,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("statusShipper") Integer statusShipper,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("gender") Integer gender,
            @RequestParam("cccd") String cccd,
            @RequestParam("birth") Date birth,
            @RequestParam(value = "images", required = false) String images,
            HttpServletRequest request,
            Model model) {

        Optional<Shipper> optionalShipper = shipperService.findByID(idShipper);
        if (!optionalShipper.isPresent()) {
            return "redirect:/login";
        }

        Shipper oldShipper = optionalShipper.get();
        Shipper updatedShipper = new Shipper();

        // Cập nhật thông tin cơ bản
        //updatedShipper.setShippings(idShipper);
        updatedShipper.setName(name);
        updatedShipper.setPhone(phone);
        updatedShipper.setAddress(address);
        updatedShipper.setCity(city);
        updatedShipper.setStatusShipper(statusShipper);
        updatedShipper.setGender(gender);
        updatedShipper.setCccd(cccd);
        updatedShipper.setBirth(birth);
        updatedShipper.setPost(oldShipper.getPost());
        //updatedShipper.setManager(oldShipper.getManager());

        // Xử lý ảnh đại diện
        String uploadPath = "path/to/upload"; // Thay đường dẫn thực tế
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            Part part = request.getPart("images1");
            if (part != null && part.getSize() > 0) {
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
                String newFileName = System.currentTimeMillis() + "." + fileExtension;
                part.write(uploadPath + "/" + newFileName);
                updatedShipper.setPicture(newFileName);
            } else if (images != null && !images.isEmpty()) {
                updatedShipper.setPicture(images);
            } else {
                updatedShipper.setPicture(oldShipper.getPicture());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Xử lý mật khẩu
        if (!oldPassword.equals(oldShipper.getPassword())) {
            model.addAttribute("errorMessage", "Incorrect old password.");
            model.addAttribute("shipper", oldShipper);
            return "views/shipper/editProfile";
        }

        updatedShipper.setPassword(
                newPassword != null && !newPassword.isEmpty() ? newPassword : oldShipper.getPassword());

        shipperService.save(updatedShipper);
        return "redirect:/shipper/profile/" + idShipper;
    }
	
}
