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
public class authorized {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorized_id;
	
	@ManyToOne 
	@JoinColumn(name = "account_id")
	private account authorize;
	
	@ManyToOne  
	@JoinColumn(name = "role_id")
	private role role;
}
