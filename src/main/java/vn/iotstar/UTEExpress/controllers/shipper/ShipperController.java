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
@RequestMapping("shippers")
public class ShipperController {

    @Autowired
    private IShipperService shipperService;

    // Hiển thị form thêm mới Shipper
    @GetMapping("add")
    public String add(ModelMap model) {
        ShipperModel shipperModel = new ShipperModel();
        shipperModel.setIsEdit(false);  // Thiết lập trạng thái thêm mới
        model.addAttribute("shipper", shipperModel);  // Chuyển dữ liệu vào view
        return "shippers/addOrEdit";
    }

    // Lưu hoặc cập nhật Shipper
    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, 
                                     @Valid @ModelAttribute("shipper") ShipperModel shipperModel, 
                                     BindingResult result) {
        if (result.hasErrors()) {  // Kiểm tra lỗi trong form
            return new ModelAndView("shippers/addOrEdit");
        }

        Shipper entity = new Shipper();
        // Chuyển dữ liệu từ model sang entity
        BeanUtils.copyProperties(shipperModel, entity);

        // Gọi service để lưu hoặc cập nhật dữ liệu
        shipperService.saveOrUpdateShipper(entity);

        String message = (shipperModel.getIsEdit()) ? "Shipper is updated!" : "Shipper is saved!";
        model.addAttribute("message", message);

        return new ModelAndView("forward:/shippers/searchpaginated", model);
    }

    // Hiển thị danh sách Shipper
    @RequestMapping("")
    public String list(ModelMap model) {
        List<Shipper> list = shipperService.getAllShippers();  // Lấy danh sách shipper từ service
        model.addAttribute("shippers", list);
        return "shippers/list";
    }

    // Chỉnh sửa Shipper
    @GetMapping("edit/{shipperId}")
    public ModelAndView edit(ModelMap model, @PathVariable("shipperId") String shipperId) {
        Optional<Shipper> optShipper = shipperService.getShipperById(shipperId);
        ShipperModel shipperModel = new ShipperModel();

        if (optShipper.isPresent()) {
            Shipper entity = optShipper.get();
            BeanUtils.copyProperties(entity, shipperModel);
            shipperModel.setIsEdit(true);  // Thiết lập trạng thái chỉnh sửa
            model.addAttribute("shipper", shipperModel);
            return new ModelAndView("shippers/addOrEdit", model);
        }

        model.addAttribute("message", "Shipper not found!");
        return new ModelAndView("forward:/shippers", model);
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
        return "forward:/shippers";
    }
}