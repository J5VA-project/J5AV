package com.J5VA.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="food")
public class food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int food_id;
	@NotBlank(message = "username not null!")
	private String food_name;
	@NotBlank(message = "price not null!")
	private double price;
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "favorite_id")
	private favorite favorite;
	
	@JsonIgnore
	@OneToMany(mappedBy = "food")
	private List<orderDetail> orderDetail;
}
