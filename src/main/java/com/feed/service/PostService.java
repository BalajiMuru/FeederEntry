package com.feed.service;

import java.util.List;

import com.feed.model.Post;
import com.feed.model.Register;

public interface PostService {
	List<Post>findApprovedPosts();
	
	List<Post> findPostsByUser(Register register);
	
	void createPost(String content, String username);
	
	
	void savePost(Post post);
	

    public List<Post> findAllPosts();
    
   

}
