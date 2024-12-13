//package vn.iotstar.UTEExpress.controllers.admin;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import vn.iotstar.UTEExpress.entity.Voucher;
//import vn.iotstar.UTEExpress.model.VoucherModel;
//import vn.iotstar.UTEExpress.service.interfaces.IVoucherService;
//
//@Controller
//@RequestMapping("/admin/voucher")
//public class VoucherController {
//	
//	@Autowired
//	IVoucherService voucherService;
//	
//	@GetMapping("")
//	public String findAllVoucher(Model model) {
//		List <Voucher> voucher = voucherService.findAll();
//		model.addAttribute("voucher",voucher);
//		
//		return "admin/listVoucher";
//	}
//	
//	@GetMapping("/addVoucher")
//	public String addVoucheer(Model model) {
//		VoucherModel voucher = new VoucherModel();
//		model.addAttribute("voucher",voucher);
//		
//		return "admin/addVoucher";
//	}
//}
