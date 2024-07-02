package com.feed.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	private String content;
	private String createdBy;
	private String updateBy;
	private LocalDateTime  createdOn;
	private LocalDateTime updateOn;
	private boolean isActive;
	private boolean isApproved;
	
	
	 @ManyToOne
	  private Register register;


}
