package vn.iotstar.UTEExpress.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="shippers")
public class Shipper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shipperID;
	
	private String password;
	private String name;
	private Integer gender; //1-nam  2-nữ
	private String picture;
	private String city;
	private String address;
	private Date birth;  //java.util
	private String phone;
	private String cccd;
	
	//1 - bận  2 - rảnh
	private Integer statusShipper;
	
	// 1 shipper thuộc 1 post duy nhất
	@ManyToOne
	@JoinColumn(name="IDPost")
	private Post post;
	
	@OneToOne
	@JoinColumn(name="username")
	private Account account;
	
	@OneToMany(mappedBy = "shipper")
	private List<Shipping> shippings;
}