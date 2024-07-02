package com.feed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feed.model.Post;
import com.feed.model.Register;

public interface PostRepository extends JpaRepository<Post, Long>{

	  List<Post> findByApproved(boolean approved);
	  List<Post> findByRegister(Register register);
}
