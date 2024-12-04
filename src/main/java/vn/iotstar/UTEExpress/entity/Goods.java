package vn.iotstar.UTEExpress.entity;

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
}
