package vn.iotstar.UTEExpress.service.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Post;

@Service
public interface IPostService {
	Optional <Post> findById(String id);
	
	Optional<Post> findByName(String name);
	
	void deletePost(String id );
	
	void addPost(Post post);
	
	void updatePost(String id);
	
	public Page<Post> getAllPost(String id, Pageable pageable);
	
	void savePost(Post post);
	
}
