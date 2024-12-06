package vn.iotstar.UTEExpress.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, String> {
	Optional <Post> findBynamePost (String namePost);
	
	Page<Post> findByIDPost(String id, Pageable pageable);
	
	List<Post> findAll();
	
	
}
