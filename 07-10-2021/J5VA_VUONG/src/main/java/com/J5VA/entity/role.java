package com.J5VA.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class role implements Serializable{
	@Id
	private String role_id;
	private String role_name;

	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<authorized> authorities;
}
