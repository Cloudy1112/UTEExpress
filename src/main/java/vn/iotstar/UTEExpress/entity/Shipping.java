package vn.iotstar.UTEExpress.entity;

import java.util.Date;

import jakarta.persistence.Entity;
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
	// do de id nen t ko tao onetomany
	@Id
	private String orderID;
	@Id
	private Integer statusOrderID;
	
//	Total
//	province = abs( mã tỉnh gửi - mã tỉnh nhận)
//	shipFee = weight * transportFee*province + weight * goodsFee*province
//	codFee = codFee * 1.1
//
//	total = shipFee + codFee - discount (voucher)
	private Integer total;
	private Date dateUpdate;
	
	@ManyToOne
	@JoinColumn(name="shipperID")
	private Shipper shipper;
	

}
