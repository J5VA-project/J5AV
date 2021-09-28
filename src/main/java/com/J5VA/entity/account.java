package com.J5VA.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
public class account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int account_id;
	@NotBlank (message = "username not null!")
	private String username;
	@NotBlank (message = "password not null!")
	private String password;
	private String fullname;
	private String email;
	private String address;
	private String phone;
	private Date hire_date; 
	private double salary;
	private Boolean gender; 
	private Date birthdate;
	private String image; 

}
