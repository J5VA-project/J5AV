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
@Table(name="size")
public class size {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int size_id;
	@NotBlank(message = "name not null!")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "food_detail_size")
	private List<foodDetail> foodDetails;
	
}
