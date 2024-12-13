package vn.iotstar.UTEExpress.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerID;
	
	private String password;
	private String name;
	private Integer gender; //1-nam  2-nữ
	private String picture;
	private String city;
	private String address;
	private Date birth;  //java.util
	private String phone;
	private String cccd;
	
	// if active, permit place order
	private Integer isActive; //accept by mangager
	
	@OneToOne
	@JoinColumn(name="username")
	private Account account;
	
	// cac địa chỉ đơn của customer
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses;

}
