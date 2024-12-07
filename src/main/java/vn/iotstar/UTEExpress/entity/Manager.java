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
	public String IDManager;
	@Column(columnDefinition = "nvarchar(50) not null")
	public String username;
	@Column(columnDefinition = "nvarchar(50) not null")
	public String password;
	@Column(columnDefinition = "nvarchar(10) not null")
	public String phone;
	
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
