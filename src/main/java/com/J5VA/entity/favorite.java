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
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private food favorite;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private customer customer;

}
