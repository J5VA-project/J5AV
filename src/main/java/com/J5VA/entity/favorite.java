package com.J5VA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private food favorite_f;

	@ManyToOne
	@JoinColumn(name = "username_custo")
	private customer favorite_c;

}
