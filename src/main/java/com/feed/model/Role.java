package com.feed.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;
	private String roleName;
	private String createdBy;
	private String updateBy;
	private LocalDateTime  createdOn;
	private LocalDateTime updateOn;

}
