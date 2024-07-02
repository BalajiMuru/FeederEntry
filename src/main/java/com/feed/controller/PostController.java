package com.feed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feed.dto.RegisterDto;
import com.feed.model.Post;
import com.feed.model.Register;
import com.feed.service.PostService;
import com.feed.service.RegisterService;

@RestController
@RequestMapping("/feeds")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	RegisterService registerService;
	
	@GetMapping
    public ResponseEntity<List<Post>> listFeeds() {
        List<Post> posts = postService.findApprovedPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/my-posts")
    public ResponseEntity<List<Post>> myPosts() {
    	String username = getUsername();
        Register register = registerService.findByRegisterName(username);
        List<Post> posts = postService.findPostsByUser(register);
        return new ResponseEntity<>(posts, HttpStatus.OK);
		
    }    
    
    @PostMapping("/create")
    public ResponseEntity<Void> createPost(@RequestParam String content) {
        String username = getUsername();
        postService.createPost(content, username);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.findAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    
    
    
    private String getUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}
