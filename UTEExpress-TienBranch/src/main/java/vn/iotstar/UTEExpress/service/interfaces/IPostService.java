package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.UTEExpress.entity.Post;

public interface IPostService {
	Optional <Post> findById(String id);
	
	Optional<Post> findByName(String namePost);

	void deletePost(String id );
	
	void addPost(Post post);
	
	public Page<Post> getPost(String id, Pageable pageable);

	void savePost(Post post);
	
	Long coutPost();

	void updatePost(String id, Post post);

	public Page<Post> getAllPost(Pageable pageable);
	
	public List<Post> findAllPost();
}

