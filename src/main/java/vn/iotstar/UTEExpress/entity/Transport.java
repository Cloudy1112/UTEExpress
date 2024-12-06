package vn.iotstar.UTEExpress.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="transports")
public class Transport implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	public String IDTransport;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String TransportType;
	
	public float TransportFee;
	
	@OneToOne(mappedBy = "transport", cascade = CascadeType.ALL)
	private Order order;
	
	@OneToMany(mappedBy = "transport", cascade = CascadeType.ALL)
	private List<Voucher> transport;
}

