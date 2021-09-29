package com.J5VA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

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
	@NotNull
	private int account_id;
	
	@ManyToOne 
	@JoinColumn(name = "username")
	private account account;
	
	@ManyToOne  
	@JoinColumn(name = "role_id")
	private role role;
}
