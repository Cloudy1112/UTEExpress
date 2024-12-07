package vn.iotstar.UTEExpress.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String IDGoods;       // UUID của Goods
    private String goodsType;     // Loại hàng hóa
    private float goodsFee;       // Phí hàng hóa

    // Quan hệ với các model liên quan
    private OrderModel order;             // Đơn hàng liên quan
    private List<VoucherModel> vouchers;  // Danh sách voucher liên quan
}