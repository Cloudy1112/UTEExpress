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
	
	@OneToOne(mappedBy = "account")
	private Manager manager;
	
	@OneToOne(mappedBy = "account")
	private Customer customer;
	
	@OneToOne(mappedBy = "account")
	private Admin admin;
	
	@OneToOne(mappedBy = "account")
	private Shipper shipper;
	
}
