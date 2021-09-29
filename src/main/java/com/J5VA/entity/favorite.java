package com.J5VA.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="favorite")
public class favorite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favorite_id;
	@NotNull
	private int food_id;
	@NotNull
	private int customer_id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "favorite")
	private List<food> food;
}
