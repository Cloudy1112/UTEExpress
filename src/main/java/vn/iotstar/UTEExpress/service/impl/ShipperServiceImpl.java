package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Shipper;
import vn.iotstar.UTEExpress.repository.ShipperRepository;
import vn.iotstar.UTEExpress.service.interfaces.IShipperService;

@Service
public class ShipperServiceImpl implements IShipperService {

    @Autowired
    private ShipperRepository shipperRepository;

    // Lấy tất cả Shipper
    @Override
    public List<Shipper> getAllShippers() {
        return shipperRepository.findAll();
    }

    // Tìm Shipper theo ID
    @Override
    public Optional<Shipper> getShipperById(String id) {
        return shipperRepository.findById(id);
    }

    // Tìm Shipper theo CCCD
    @Override
    public Shipper getShipperByCccd(String cccd) {
        return shipperRepository.findByCccd(cccd);
    }

    // Tìm tất cả Shipper theo trạng thái
    @Override
    public List<Shipper> getShippersByStatus(Boolean status) {
        return shipperRepository.findByStatusShipper(status);
    }

    // Tìm Shipper theo thành phố
    @Override
    public List<Shipper> getShippersByCity(String city) {
        return shipperRepository.findByCity(city);
    }

    // Tìm Shipper theo tên gần đúng
    @Override
    public List<Shipper> searchShippersByName(String name) {
        return shipperRepository.findByNameContaining(name);
    }

    // Tạo hoặc cập nhật Shipper
    @Override
    public Shipper saveOrUpdateShipper(Shipper shipper) {
        return shipperRepository.save(shipper);
    }

    // Xóa Shipper theo ID
    @Override
    public void deleteShipper(String id) {
        shipperRepository.deleteById(id);
    }


}