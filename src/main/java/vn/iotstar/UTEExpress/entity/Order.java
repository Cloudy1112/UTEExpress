package vn.iotstar.UTEExpress.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="orders")

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String IDOrder;
	
	private float shipFee;
	private float codFee;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String source;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String sourceCity;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String dest;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String destCity;
	
	private int width;
	private int height;
	private int weigth;
	
	private Date orderDate;
	
	//thêm date time các thứ
	private Integer status;
	/// Thuoc tinh anh xa
		//IDTransport anh xa voi Transport
		//IDGoods anh xa voi Goods
		//IDVoucher anh xa voi Voucher
		//IDShipper anh xa voi Shipper
		//IDUser anh xa voi User
		//IDPost anh xa voi User
	
	@OneToOne
    @JoinColumn(name = "IDGoods") //tên column tham chiếu trong database
	private Goods good;
	
	@OneToOne
	@JoinColumn(name="IDTransport")
	private Transport transport;
	
	@ManyToOne
	@JoinColumn(name="IDUser")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="IDVoucher")
	private Voucher voucher;
	
	@ManyToOne
	@JoinColumn(name="IDShipper")
	private Shipper shipper;
	
	@ManyToOne
	@JoinColumn(name="IDPost")
	private Post postOffice;
	
}
