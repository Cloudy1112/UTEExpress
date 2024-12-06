package vn.iotstar.UTEExpress.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="goods")
public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	public String IDGoods;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String GoodsType;
	
	public float GoodsFee;
	
	//one to one với bảng order
	@OneToOne(mappedBy = "good", cascade = CascadeType.ALL)
	private Order order;
	
	@OneToMany(mappedBy = "goods", cascade = CascadeType.ALL)
	private List<Voucher> vouchers;
}	

