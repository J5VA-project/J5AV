package com.J5VA.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="foodCategory")
public class foodCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodCategory_id;
	@NotBlank(message = "foodCategory_name not null!")
	private String foodCategory_name;
	@NotBlank(message = "description not null!")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category_id")
	List<foodDetail> foodDetails;

}
