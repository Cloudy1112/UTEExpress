package vn.iotstar.UTEExpress.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.UTEExpress.entity.Shipper;

@Repository
public interface IShipperRepository extends JpaRepository<Shipper, Integer> {
	// Tìm shipper theo username (liên kết với Account)
    Shipper findByAccountUsername(String username);

    // Lấy danh sách shipper theo thành phố
    List<Shipper> findByCity(String city);

    // Tìm shipper theo trạng thái (rảnh hoặc bận)
    List<Shipper> findByStatusShipper(Integer statusShipper);
	
}
