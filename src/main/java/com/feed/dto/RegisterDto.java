package com.feed.dto;

import java.time.LocalDateTime;

import com.feed.model.Role;

import jakarta.persistence.Entity;
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

public class RegisterDto {
	private long id;
	private String userName;
	private String emailId;
	private String phoneNo;
	private Role role;

	private String createdBy;
	private String updateBy;
	private LocalDateTime  createdOn;
	private LocalDateTime updateOn;
	private boolean isActive;
}
