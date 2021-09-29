package com.J5VA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	foodDetail foodDetail;
	
}
