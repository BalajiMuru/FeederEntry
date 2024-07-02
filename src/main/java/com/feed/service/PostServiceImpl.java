package com.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feed.model.Post;
import com.feed.model.Register;
import com.feed.repository.PostRepository;
import com.feed.repository.RegisterRepository;

@Service
public class PostServiceImpl implements PostService{
	
	 @Autowired
	 private PostRepository postRepository;
	 @Autowired
	 private RegisterRepository registerRepository;
	 @Autowired
	 private RegisterService registerService;

	 
	public  List<Post>findApprovedPosts(){
		return postRepository.findByApproved(true);
	
	}
	
	public List<Post> findPostsByUser(Register register) {
	        return postRepository.findByRegister(register);
	}
	
	public void savePost(Post post) {
		postRepository.save(post);
	}

	@Override
	public void createPost(String content, String username) {
		Register register = registerService.findByRegisterName(username);
		  Post post = new Post();
	        post.setContent(content);
	        post.setRegister(register);
	        post.setApproved(false); // Needs admin approval
	        post.setCreatedBy(username);
	        savePost(post);
		
	}

	@Override
	public List<Post> findAllPosts() {
		return postRepository.findAll();
	}
}














