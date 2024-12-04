package vn.iotstar.UTEExpress.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="managers")
public class Manager {
	@Id
	public String IDManager;
	@Column(columnDefinition = "nvarchar(50) not null")
	public String username;
	@Column(columnDefinition = "nvarchar(50) not null")
	public String password;
	@Column(columnDefinition = "nvarchar(10) not null")
	public String phone;
}
