package vn.iotstar.UTEExpress.controllers.admin;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import vn.iotstar.UTEExpress.dto.VoucherDTO;
import vn.iotstar.UTEExpress.entity.Transport;
import vn.iotstar.UTEExpress.entity.Voucher;
import vn.iotstar.UTEExpress.service.IGoodsService;
import vn.iotstar.UTEExpress.service.ITransportService;
import vn.iotstar.UTEExpress.service.IVoucherService;


@Controller
@RequestMapping("/admin/{id}/voucher")
public class AdminVoucherController {
	@Autowired IVoucherService voucherService;
	@Autowired ITransportService transportService;
	@Autowired IGoodsService goodsService;
	
	@GetMapping("")
	public String VoucherHome(@PathVariable Integer id, Model model) {
		//Tìm ra danh sách các Voucher còn hạn sử dụng
		Date currentDate = Date.from(Instant.now());
		List<Voucher> vouchers = voucherService.findValidVoucher(currentDate);
		List<VoucherDTO> voucherDTOs = new ArrayList<>();
		for (Voucher voucher : vouchers) {
			VoucherDTO dto = new VoucherDTO();
			dto.setAmount(voucher.getAmount());
			dto.setDateEnd(voucher.getDateEnd());
			dto.setDateStart(voucher.getDateStart());
			dto.setGoods(goodsService.findById(voucher.getGoods().getGoodsID()));
			dto.setTransport(transportService.findById(voucher.getTransport().getTransportID()));
			dto.setVoucherID(voucher.getVoucherID());
			dto.setVoucherName(voucher.getVoucherName());
			voucherDTOs.add(dto);
		}
		
		model.addAttribute("vouchers", voucherDTOs);
		
		return "admin/voucher";
	}
	
	@GetMapping("/expired")
	public String VoucherExpired(@PathVariable Integer id, Model model) {
		//Tìm ra danh sách các Voucher hết hạn sử dụng hoặc có số lượng =0
		Date currentDate = Date.from(Instant.now());
		List<Voucher> vouchers = voucherService.findExpiredVoucher(currentDate);
		List<VoucherDTO> voucherDTOs = new ArrayList<>();
		for (Voucher voucher : vouchers) {
			VoucherDTO dto = new VoucherDTO();
			dto.setAmount(voucher.getAmount());
			dto.setDateEnd(voucher.getDateEnd());
			dto.setDateStart(voucher.getDateStart());
			dto.setGoods(goodsService.findById(voucher.getGoods().getGoodsID()));
			dto.setTransport(transportService.findById(voucher.getTransport().getTransportID()));
			dto.setVoucherID(voucher.getVoucherID());
			dto.setVoucherName(voucher.getVoucherName());
			voucherDTOs.add(dto);
		}
		
		model.addAttribute("vouchers", voucherDTOs);
		return "admin/voucher";
	}
	
	@GetMapping("/inactive")
	public String VoucherInactive(@PathVariable Integer id, Model model) {
		//Tìm ra danh sách các Voucher hết hạn sử dụng hoặc có số lượng =0
		Date currentDate = Date.from(Instant.now());
		List<Voucher> vouchers = voucherService.findInactiveVoucher(currentDate);
		List<VoucherDTO> voucherDTOs = new ArrayList<>();
		for (Voucher voucher : vouchers) {
			VoucherDTO dto = new VoucherDTO();
			dto.setAmount(voucher.getAmount());
			dto.setDateEnd(voucher.getDateEnd());
			dto.setDateStart(voucher.getDateStart());
			dto.setGoods(goodsService.findById(voucher.getGoods().getGoodsID()));
			dto.setTransport(transportService.findById(voucher.getTransport().getTransportID()));
			dto.setVoucherID(voucher.getVoucherID());
			dto.setVoucherName(voucher.getVoucherName());
			voucherDTOs.add(dto);
		}
		
		model.addAttribute("vouchers", voucherDTOs);
		return "admin/voucher";
	}
	
}
