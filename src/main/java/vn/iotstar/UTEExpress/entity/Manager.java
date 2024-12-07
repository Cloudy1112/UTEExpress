package vn.iotstar.UTEExpress.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="managers")
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String IDManager;
	@Column(columnDefinition = "nvarchar(50) not null")
	private String username;
	@Column(columnDefinition = "nvarchar(50) not null")
	private String password;
	@Column(columnDefinition = "nvarchar(10) not null")
	private String phone;
	
	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	private List<Voucher> vouchers;
	
	@OneToOne
	@JoinColumn(name="IDPost")
	private Post post;
	
	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	private List<Shipper> shippers;
	
	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	private List<User> users;
}
