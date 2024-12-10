package vn.iotstar.UTEExpress.controllers.shipper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.model.ShipperModel;
import vn.iotstar.UTEExpress.service.interfaces.IShipperService;

@Controller
@RequestMapping("/shipper")
public class ShipperController {

	@Autowired
	private IShipperService shipperService;

	@GetMapping("/dashboard")
    public String showDashboard(ModelMap model) {
        model.addAttribute("title", "Shipper Dashboard");
        return "shipper/dashboard"; // Chỉ định tệp Thymeleaf cần hiển thị
    }
	
	// Hiển thị form thêm mới Shipper
	@GetMapping("/add")
	public String add(ModelMap model) {
		ShipperModel shipperModel = new ShipperModel();
		shipperModel.setIsEdit(false);
		model.addAttribute("shipper", shipperModel);
		return "shipper/categories/addOrEdit";
	}

	// Lưu hoặc cập nhật Shipper
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("shipper") ShipperModel shipperModel,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("shipper/categories/addOrEdit");
		}

		Shipper entity = new Shipper();
		BeanUtils.copyProperties(shipperModel, entity);
		shipperService.saveOrUpdateShipper(entity);

		String message = (shipperModel.getIsEdit()) ? "Shipper is updated!" : "Shipper is saved!";
		model.addAttribute("message", message);

		return new ModelAndView("forward:/shipper/searchpaginated", model);
	}

	// Hiển thị danh sách Shipper
	@GetMapping("")
	public String list(ModelMap model) {
		List<Shipper> list = shipperService.getAllShippers();
		model.addAttribute("shippers", list);
		return "shipper/categories/list";
	}

	// Chỉnh sửa Shipper
	@GetMapping("edit/{shipperId}")
	public ModelAndView edit(ModelMap model, @PathVariable("shipperId") String shipperId) {
		Optional<Shipper> optShipper = shipperService.getShipperById(shipperId);
		ShipperModel shipperModel = new ShipperModel();

		if (optShipper.isPresent()) {
			Shipper entity = optShipper.get();
			BeanUtils.copyProperties(entity, shipperModel);
			shipperModel.setIsEdit(true);
			model.addAttribute("shipper", shipperModel);
			return new ModelAndView("shipper/categories/addOrEdit", model);
		}

		model.addAttribute("message", "Shipper not found!");
		return new ModelAndView("redirect:/shipper");
	}

	// Xóa Shipper
	@GetMapping("delete/{shipperId}")
	public String delete(ModelMap model, @PathVariable("shipperId") String shipperId) {
		try {
			shipperService.deleteShipper(shipperId);
			model.addAttribute("message", "Shipper deleted successfully!");
		} catch (Exception e) {
			model.addAttribute("message", "Error deleting shipper.");
		}
		return "redirect:/shipper";
	}

	// Tìm kiếm Shipper
	@GetMapping("searchpaginated")
	public String searchPaginated(ModelMap model) {
		// Logic tìm kiếm nếu cần
		return "shipper/categories/searchpaginated";
	}

}
