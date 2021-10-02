package com.J5VA.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="fooddetail")
public class foodDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int food_id;
	@NotNull
	private int category_id;
	@NotBlank(message = "status not null!")
	private boolean status;
	@NotBlank(message = "description not null!")
	private String description;
	private String image_title1;
	private String image_title2;
	
	@ManyToOne
	@JoinColumn(name = "size_id")
	private size food_detail_size;

	@OneToOne
	@JoinColumn(name = "food_id")
	private food food;
}
