package vn.iotstar.UTEExpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="accounts")
public class Account {
	@Id
	private String username;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name="roleID")
	private Role role;
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Manager manager;
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Admin admin;
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Shipper shipper;
	
}
