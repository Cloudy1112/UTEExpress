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
@Table(name ="vouchers")
public class Voucher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String IDVoucher;
	
	private String vouchername;
	
	@Column(columnDefinition = "nvarchar(500)")
	private String description;
	
	
	private Date dayStart;
	private Date dayEnd;
	
	private int amount;
	
	@OneToMany(mappedBy = "voucher", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	//IDTransport anh xa bang Transport
	@ManyToOne
	@JoinColumn(name="IDTransport")
	private Transport transport;
	//IDGood anh xa toi Goods
	@ManyToOne
	@JoinColumn(name="IDGoods")
	private Goods goods;
	
	//IDManager anh xa toi Manager
	@ManyToOne
	@JoinColumn(name="IDManager")
	private Manager manager;
}
