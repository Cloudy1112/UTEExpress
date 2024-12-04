package vn.iotstar.UTEExpress.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="transports")
public class Transport {
	@Id
	public String IDTransport;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String TransportType;
	
	public float TransportFee;
	
	@OneToOne(mappedBy = "transport", cascade = CascadeType.ALL)
	private Order order;
	
	@OneToMany(mappedBy = "transport", cascade = CascadeType.ALL)
	private Transport transport;
}

