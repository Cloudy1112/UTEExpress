package vn.iotstar.UTEExpress.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String IDManager;    // UUID của Manager
    private String username;     // Tên đăng nhập
    private String password;     // Mật khẩu (lưu ý cần mã hóa trong thực tế)
    private String phone;        // Số điện thoại

    // Liên kết tới các model khác
    private List<VoucherModel> vouchers; // Danh sách các voucher do Manager quản lý
    private PostModel post;              // Bưu cục (Post) do Manager phụ trách
    private List<ShipperModel> shippers; // Danh sách shipper do Manager quản lý
    private List<UserModel> users;       // Danh sách người dùng liên kết với Manager
}
