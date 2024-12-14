package vn.iotstar.UTEExpress.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="shipping")
public class Shipping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shippingID;
	// do de id nen t ko tao onetomany
	
	private String orderID;
	private Integer statusOrderID;
	
//	Total
//	province = abs( mã tỉnh gửi - mã tỉnh nhận)
//	shipFee = weight * transportFee*province + weight * goodsFee*province
//	codFee = codFee * 1.1
//
//	total = shipFee + codFee - discount (voucher)
	private Integer total;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateUpdate;
	
	@ManyToOne
	@JoinColumn(name="IDShipper")
	private Shipper shipper;
	

}
