package vn.iotstar.UTEExpress.entity;

import java.sql.Date;

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
	
	public String IDTransport;
	public String IDGoods;
	
	public Date dayStart;
	public Date dayEnd;
	
	public int amount;
	
}
