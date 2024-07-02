package com.feed.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userName;
	private String emailId;
	private String phoneNo;
   
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role")
	private Role role;
    
	private String createdBy;
	private String updateBy;
	private LocalDateTime  createdOn;
	private LocalDateTime updateOn;
	private boolean isActive;


}
