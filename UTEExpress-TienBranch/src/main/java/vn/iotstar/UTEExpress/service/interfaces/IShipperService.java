package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;
import java.util.Optional;

import vn.iotstar.UTEExpress.entity.Order;
import vn.iotstar.UTEExpress.entity.Shipper;

public interface IShipperService {
	
	// Lấy thông tin shipper theo ID
    Shipper getShipperById(Integer id);

    // Lấy thông tin shipper theo username
    Shipper getShipperByUsername(String username);

    // Lấy danh sách shipper theo thành phố
    List<Shipper> getShippersByCity(String city);

    // Lấy danh sách shipper theo trạng thái
    List<Shipper> getShippersByStatus(Integer statusShipper);

    // Lưu hoặc cập nhật thông tin shipper
    void saveOrUpdateShipper(Shipper shipper);

    // Xóa shipper theo ID
    void deleteShipperById(Integer id);

}
