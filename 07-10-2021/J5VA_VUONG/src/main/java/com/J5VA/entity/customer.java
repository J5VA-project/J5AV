package com.J5VA.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
	private String username_custo;
	
	private String password;
	
	private String fullname;
	
	private String phone_No;
	
	private String address;
	
	private String email;
	private String image;
	
	@JsonIgnore
	@OneToMany (mappedBy = "customer")
	private List<orders> orders;
	
	@JsonIgnore
	@OneToMany (mappedBy = "customer")
	private List<favorite> favorite;
}









