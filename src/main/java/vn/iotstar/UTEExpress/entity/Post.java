package vn.iotstar.UTEExpress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="posts")
public class Post {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postID;
	private String postName;
	
	// co nhieu post thuoc ve cung 1 thanh pho
	@ManyToOne
	@JoinColumn(name="IDCity")
	private City city;

}