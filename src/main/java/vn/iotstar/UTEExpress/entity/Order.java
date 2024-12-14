package vn.iotstar.UTEExpress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="orders")
public class Order {
	@Id
	private String orderID;
	
	private Integer weight; //kg
	private Integer height;
	private Integer width;
	
	private String destCity; // để tìm post từ bảng city
	private String sourceCity;
	
	// địa chỉ chi tiết
	private String dest;
	private String source;
	
	private Integer codFee;
	private Integer shipFee;
	
	@ManyToOne
	@JoinColumn(name="IDVoucher")
	private Voucher voucher;
	
	@ManyToOne
	@JoinColumn(name="IDGoods")
	private Goods goods;
	
	@ManyToOne
	@JoinColumn(name="IDTransport")
	private Transport transport;
	
	@ManyToOne
	@JoinColumn(name="IDCustomer")
	private Customer customer;

	@OneToOne
	@JoinColumn(name="shippingID")
	private Shipping shipping;
}
