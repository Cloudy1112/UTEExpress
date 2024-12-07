package vn.iotstar.UTEExpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.UTEExpress.entity.Shipper;

public interface ShipperRepository extends JpaRepository<Shipper, String> {
    // Tìm Shipper theo CCCD
    Shipper findByCccd(String cccd);
    
    // Tìm Shipper theo trạng thái
    List<Shipper> findByStatusShipper(Boolean statusShipper);
    
    // Tìm Shipper theo thành phố
    List<Shipper> findByCity(String city);
    
    // Tìm Shipper theo tên
    List<Shipper> findByNameContaining(String name);
}
