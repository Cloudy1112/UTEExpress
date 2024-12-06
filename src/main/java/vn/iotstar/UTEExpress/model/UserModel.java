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
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String IDUser;      // UUID của User
    private String cccd;        // CCCD/CMND của User
    private String phone;       // Số điện thoại
    private String name;        // Tên User
    private Boolean gender;     // Giới tính (true: Nam, false: Nữ)
    private Date birth;         // Ngày sinh
    private String address;     // Địa chỉ
    private String city;        // Thành phố
    private String picture;     // Ảnh đại diện (đường dẫn)
    private String password;    // Mật khẩu (đã được mã hóa)
    private Boolean isEmailActive; // Trạng thái kích hoạt email

    // Liên kết tới các model khác
    private List<RateModel> rates;  // Danh sách đánh giá (RateModel)
    private List<OrderModel> orders; // Danh sách đơn hàng (
}
