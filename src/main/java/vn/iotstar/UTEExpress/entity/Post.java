package vn.iotstar.UTEExpress.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="posts")

public class Post {
	@Id
	public String IDPost;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String namePost;
}
