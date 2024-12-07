package vn.iotstar.UTEExpress.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String IDRate;       // UUID của đánh giá
    private ShipperModel shipper; // Shipper được đánh giá
    private UserModel user;       // Người dùng thực hiện đánh giá
    private String feedback;      // Nội dung phản hồi
    private int star;             // Số sao đánh giá (1-5)
}