package vn.iotstar.UTEExpress.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="rates")
public class Rate implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	public String IDrate;
	
	//Anh xa IDShipper anh xa Shipper
	@ManyToOne
	@JoinColumn(name="IDShipper")
	private Shipper shipper;
	//Anh xa IDUser anh xa User
	@ManyToOne
	@JoinColumn(name="IDUser")
	private User user;
	
	public String feedback;
	public int star;
}
