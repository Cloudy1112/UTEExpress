package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Post;
import vn.iotstar.UTEExpress.repository.PostRepository;
import vn.iotstar.UTEExpress.service.interfaces.IPostService;

@Service
public class PostService implements IPostService {

	@Autowired
	PostRepository postRepository;
	
	@Override
	public Optional<Post> findById(String id) {
		// TODO Auto-generated method stub
		return postRepository.findById(id);
	}

	@Override
	public Optional<Post> findByName(String namePost) {
		// TODO Auto-generated method stub
		return postRepository.findBynamePost(namePost);
		//return postRepository.f
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
	public void updatePost(String id, Post post) {
		Post postBefore = postRepository.findById(id).orElseThrow();
		postBefore.setNamePost(post.getNamePost());
		postRepository.save(postBefore);
		
	}

	@Override
	public Page<Post> getPost(String id, Pageable pageable) {
		return postRepository.findByIDPost(id, pageable);
	}
	
	@Override
	public Page<Post> getAllPost(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Override
	public void savePost(Post post) {
		postRepository.save(post);
		
	}

	@Override
	public Long coutPost() {
		return postRepository.count();
	}

	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}
	
	

}
