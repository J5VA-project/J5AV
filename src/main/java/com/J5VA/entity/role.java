package com.J5VA.entity;

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
@Table(name="role")
public class role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int role_id;
	@NotBlank(message = "role_name not null!")
	private String role_name;
}
