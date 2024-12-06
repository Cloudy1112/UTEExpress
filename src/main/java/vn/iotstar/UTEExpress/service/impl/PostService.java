package vn.iotstar.UTEExpress.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.UTEExpress.entity.Post;
import vn.iotstar.UTEExpress.repository.PostRepository;
import vn.iotstar.UTEExpress.service.interfaces.IPostService;

public class PostService implements IPostService {

	@Autowired
	PostRepository postRepository;
	
	@Override
	public Optional<Post> findById(String id) {
		// TODO Auto-generated method stub
		return postRepository.findById(id);
	}

	@Override
	public Optional<Post> findByName(String name) {
		// TODO Auto-generated method stub
		return postRepository.findByName(name);
	}

	@Override
	public void deletePost(String id) {
		postRepository.deleteById(id);
	}

	@Override
	public void addPost(Post post) {
		postRepository.save(post);
	}

	@Override
	public void updatePost(String id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post" + id + "not found"));
		postRepository.save(post);
		
	}

	@Override
	public Page<Post> getAllPost(String id, Pageable pageable) {
		return postRepository.getAllPost(id, pageable);
	}

	@Override
	public void savePost(Post post) {
		postRepository.save(post);
		
	}

}
