package vn.iotstar.UTEExpress.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="posts")
public class Post implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	
	@Column(name = "idPost")
	public String IDPost; 
	
	
	
	@Column(name = "namePost", columnDefinition = "nvarchar(100)")
	public String namePost;
	
	// một post có nhiều shipper
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Shipper> shippers;
	
	@OneToMany(mappedBy = "postOffice", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
	private Manager manager; 
}
