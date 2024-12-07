package vn.iotstar.UTEExpress.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.aspectj.weaver.ast.Or;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="shippers")
public class Shipper implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String IDShipper;
	private String cccd;
	private String phone;
	private String name;
	private Boolean gender;
	private Date birth;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String address;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String city;
	
	@Column(columnDefinition = "nvarchar(300)")
	private String picture;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	private String password;
	
	private Boolean statusShipper;
	
	//Anh xa IDrate anh xa toi Rate
	@OneToMany(mappedBy = "shipper", cascade = CascadeType.ALL)
	private List<Rate> rates;
	
	//Anh xa IDPost toi Post
	@ManyToOne
	@JoinColumn(name="IDPost")
	private Post post;
	
	@OneToMany(mappedBy = "shipper", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@ManyToOne
	@JoinColumn(name="IDManager")
	private Manager manager;
	
	
}
