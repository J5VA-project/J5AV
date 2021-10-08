package com.J5VA.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@NotBlank(message = "username not null!")
	private String username_custo;
	@NotBlank(message = "password not null!")
	private String password;
	@NotBlank(message = "fullName not null!")
	private String fullname;
	@Size(max = 15, message = "Phone Number has be 15 charater")
	private String phone_No;
	private String address;
	private String email;
	private String image;
	
	@JsonIgnore
	@OneToMany (mappedBy = "order")
	private List<orders> orders;
	
	@JsonIgnore
	@OneToMany (mappedBy = "favorite_c")
	private List<favorite> favorite;
}









