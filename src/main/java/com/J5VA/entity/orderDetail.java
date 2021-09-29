package com.J5VA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orderDetail")
public class orderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetail_id;
	@NotNull
	private int quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private food food;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private orders orders;
}
