package vn.iotstar.UTEExpress.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String IDOrder;       // UUID của Order
    private float shipFee;        // Phí vận chuyển
    private float codFee;         // Phí thu hộ COD
    private String source;        // Địa chỉ nguồn
    private String sourceCity;    // Thành phố nguồn
    private String dest;          // Địa chỉ đích
    private String destCity;      // Thành phố đích
    private int width;            // Chiều rộng gói hàng
    private int height;           // Chiều cao gói hàng
    private int weigth;           // Trọng lượng gói hàng
    private Date orderDate;       // Ngày đặt hàng
    private Integer status;       // Trạng thái đơn hàng

    // Liên kết đến các model liên quan
    private GoodsModel good;           // Hàng hóa
    private TransportModel transport;  // Vận chuyển
    private UserModel user;            // Người dùng
    private VoucherModel voucher;      // Mã giảm giá
    private ShipperModel shipper;      // Shipper giao hàng
    private PostModel postOffice;      // Bưu cục liên quan
}
