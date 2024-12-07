package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;
import java.util.Optional;

import vn.iotstar.UTEExpress.entity.Shipper;

public interface IShipperService {
    // Lấy tất cả Shipper
    List<Shipper> getAllShippers();

    // Tìm Shipper theo ID
    Optional<Shipper> getShipperById(String id);

    // Tìm Shipper theo CCCD
    Shipper getShipperByCccd(String cccd);

    // Tìm tất cả Shipper theo status
    List<Shipper> getShippersByStatus(Boolean status);

    // Tìm Shipper theo thành phố
    List<Shipper> getShippersByCity(String city);

    // Tìm Shipper theo tên 
    List<Shipper> searchShippersByName(String name);

    // Tạo hoặc cập nhật Shipper
    Shipper saveOrUpdateShipper(Shipper shipper);

    // Xóa Shipper theo ID
    void deleteShipper(String id);
    
    
}
