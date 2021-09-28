package com.J5VA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
public class customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	@NotBlank(message = "username not null!")
	private String username;
	@NotBlank(message = "password not null!")
	private String password;
	@NotBlank(message = "fullName not null!")
	private String fullName;
	@Size(max = 15, message = "Phone Number has be 15 charater")
	private String phone_No;
	private String address;
	private String email;
	private String image;
}
