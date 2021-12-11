package com.J5VA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="authorized")
public class Authorized {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorized_id;
	
	@ManyToOne 
	@JoinColumn(name = "username")
	private Account authorize;
	
	@ManyToOne  
	@JoinColumn(name = "role_id")
	private Role role;
}
