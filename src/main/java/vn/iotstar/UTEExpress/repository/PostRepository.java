package vn.iotstar.UTEExpress.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, String> {
	Optional <Post> findByName (String name);
	
	Long countPost();
	
	Page<Post> getAllPost(String id, Pageable pageable);
	
}
