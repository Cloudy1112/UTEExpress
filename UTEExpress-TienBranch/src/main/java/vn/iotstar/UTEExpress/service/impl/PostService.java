package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Post;
import vn.iotstar.UTEExpress.repository.IPostRepository;
import vn.iotstar.UTEExpress.service.interfaces.IPostService;
@Service
public class PostService implements IPostService {

	@Autowired
    private IPostRepository postRepository;

	@Override
	public Optional<Post> findById(String id) {
		return postRepository.findById(Integer.parseInt(id)); 
	}

	@Override
	public Optional<Post> findByName(String namePost) {
        return postRepository.findBynamePost(namePost);

	}

	@Override
	public void deletePost(String id) {
		postRepository.deleteById(Integer.parseInt(id));		
	}

	@Override
	public void addPost(Post post) {
        postRepository.save(post);
		
	}

	@Override
	public Page<Post> getPost(String id, Pageable pageable) {
		 return postRepository.findByIDPost(id, pageable);
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
	public void updatePost(String id, Post post) {
	
	        }
	

	@Override
	public Page<Post> getAllPost(Pageable pageable) {
        return postRepository.findAll(pageable);

	}

	@Override
	public List<Post> findAllPost() {
		 return postRepository.findAll();

 }
}	
