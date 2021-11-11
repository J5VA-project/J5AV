package com.J5VA.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class account {
	@Id
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String address;
	private String phone;
	private Date hire_date;
	private double salary;
	private boolean gender;
	private Date birthdate;
	private String image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<authorized> authorities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<orders> orders;
}
