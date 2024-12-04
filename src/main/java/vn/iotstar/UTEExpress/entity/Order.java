package vn.iotstar.UTEExpress.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="orders")

public class Order {
	@Id
	public String IDOrder;
	
	public float shipFee;
	public float codFee;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String source;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String sourceCity;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String dest;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String destCity;
	
	public int width;
	public int height;
	public int weigth;
	
	/// Thuoc tinh anh xa
		//IDTransport anh xa voi Transport
		//IDGoods anh xa voi Goods
		//IDVoucher anh xa voi Voucher
		//IDShipper anh xa voi Shipper
		
	
	
}
