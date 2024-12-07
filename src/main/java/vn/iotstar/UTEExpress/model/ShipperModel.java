package vn.iotstar.UTEExpress.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipperModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String IDShipper;      // UUID của Shipper
    private String cccd;           // Căn cước công dân
    private String phone;          // Số điện thoại
    private String name;           // Tên shipper
    private Boolean gender;        // Giới tính (true: nam, false: nữ)
    private Date birth;            // Ngày sinh
    private String address;        // Địa chỉ
    private String city;           // Thành phố
    private String picture;        // Ảnh đại diện
    private String password;       // Mật khẩu
    private Boolean statusShipper; // Trạng thái shipper

    // Liên kết tới các model khác
    private List<RateModel> rates; // Danh sách đánh giá (Rate)
    private PostModel post;        // Liên kết tới Post
    private List<OrderModel> orders; // Danh sách đơn hàng
    private ManagerModel manager;  // Liên kết tới Manager
    
    private Boolean isEdit = false;
	
}