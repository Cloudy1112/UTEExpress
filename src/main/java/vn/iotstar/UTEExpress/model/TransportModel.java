package vn.iotstar.UTEExpress.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String IDTransport;       // UUID của phương tiện vận chuyển
    private String transportType;     // Loại phương tiện vận chuyển (ví dụ: xe tải, máy bay)
    private float transportFee;       // Phí vận chuyển

    // Quan hệ với các model liên quan
    private OrderModel order;                // Đơn hàng liên quan đến phương tiện vận chuyển
    private List<VoucherModel> vouchers;     // Danh sách voucher liên quan đến phương tiện vận chuyển
}
