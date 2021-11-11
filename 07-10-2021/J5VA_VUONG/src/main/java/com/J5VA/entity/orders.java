package com.J5VA.entity;

import java.util.Date;
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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	@NotNull
	private Date orderdate;
	private int discount;
	@NotNull
	private int status;
	@NotBlank(message = "address not null!")
	private String address;

	@ManyToOne
	@JoinColumn(name = "username_custo")
	private customer customer;

	@ManyToOne
	@JoinColumn(name = "username")
	private account order;

	@JsonIgnore
	@OneToMany(mappedBy = "orders")
	private List<orderDetail> orderDetails;

}







