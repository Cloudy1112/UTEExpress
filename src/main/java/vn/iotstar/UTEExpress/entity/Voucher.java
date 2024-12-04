package vn.iotstar.UTEExpress.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="vouchers")
public class Voucher {
	@Id
	public String IDVoucher;
	
	public String vouchername;
	
	@Column(columnDefinition = "nvarchar(500)")
	public String description;
	
	
	public Date dayStart;
	public Date dayEnd;
	
	public int amount;
	
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
