package com.J5VA.entity;

import java.io.Serializable;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food")
public class Food implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int food_id;
	private String food_name;
	private double price;
	String photo;

	@JsonIgnore
	@OneToMany(mappedBy = "favorite_f")
	private List<Favorite> favorite;

	@JsonIgnore
	@OneToMany(mappedBy = "food")
	private List<OrderDetail> orderDetail;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "food_id")
	private FoodDetail food_detail;
}
