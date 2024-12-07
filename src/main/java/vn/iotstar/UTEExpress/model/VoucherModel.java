package vn.iotstar.UTEExpress.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoucherModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String IDVoucher;        // UUID của Voucher
    private String vouchername;      // Tên voucher
    private String description;      // Mô tả voucher
    private Date dayStart;           // Ngày bắt đầu
    private Date dayEnd;             // Ngày kết thúc
    private int amount;              // Số lượng voucher

    // Liên kết tới các model khác
    private TransportModel transport; // Liên kết tới TransportModel
    private GoodsModel goods;         // Liên kết tới GoodsModel
    private ManagerModel manager;     // Liên kết tới ManagerModel
}
