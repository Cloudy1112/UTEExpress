package vn.iotstar.UTEExpress.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String IDPost;         // UUID của Post
    private String namePost;       // Tên của Post
    private List<ShipperModel> shippers; // Danh sách các Shipper liên kết với Post
    private List<OrderModel> orders;     // Danh sách các Order liên kết với Post
    private ManagerModel manager;        // Quản lý của Post
}