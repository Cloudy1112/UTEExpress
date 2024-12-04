package vn.iotstar.UTEExpress.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="goods")
public class Goods {
	@Id
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

