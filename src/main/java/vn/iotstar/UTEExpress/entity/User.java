package vn.iotstar.UTEExpress.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="users")

public class User {
	@Id
	public String IDUser;
	public String cccd;
	public String phone;
	public String name;
	public Boolean gender;
	public Date birth;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String address;
	
	@Column(columnDefinition = "nvarchar(50)")
	public String city;
	
	@Column(columnDefinition = "nvarchar(300)")
	public String picture;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	public String password;
	
	public Boolean IsEmailActive;

}
