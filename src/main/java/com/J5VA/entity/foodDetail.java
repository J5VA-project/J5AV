package com.J5VA.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="foodDetail")
public class foodDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodDetail_id;
	@NotNull
	private int category_id;
	@NotBlank(message = "status not null!")
	private boolean status;
	@NotBlank(message = "description not null!")
	private String description;
	@NotNull
	private int size_id;
	private String image_title1;
	private String image_title2;
	
	@JsonIgnore
	@OneToMany(mappedBy = "foodDetail")
	private List<size> size;

	@OneToOne
	@JoinColumn(name = "food_id_food")
	private food food;

}
