package vn.iotstar.UTEExpress.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="users")

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy = GenerationType.UUID)
	public String IDUser;
	public String cccd;
	public String phone;
	public String name;
	public Boolean gender;
	public Date birth;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String address;
	
	@Column(columnDefinition = "nvarchar(50)")
	public String city;
	
	@Column(columnDefinition = "nvarchar(300)")
	public String picture;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	public String password;
	
	public Boolean IsEmailActive;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Rate> rates;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@ManyToOne
	@JoinColumn(name="IDManager")
	private Manager manager;

}
