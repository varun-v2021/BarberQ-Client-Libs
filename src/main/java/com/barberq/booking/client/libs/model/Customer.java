package com.barberq.booking.client.libs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "`Booking_Customer`")
@ApiModel("All details about the booked customer here")
@JsonSerialize
public class Customer {

	@Id
	@Column(name = "customer_id")
	private Integer id;

	// As name in DB schema is not the same as in this Entity
	// It is related to spring.jpa.hibernate.naming.physical-strategy property
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@NotBlank
	@ApiModelProperty(notes = "Name should not less than 2 character")
	@Column(name = "customer_name")
	private String customerName;

	@Column
	private Long mobile;

	public Customer() {
	}

	public Customer(Integer id, String customerName, Long mobile) {
		this.id = id;
		this.customerName = customerName;
		this.mobile = mobile;
	}

	public Customer(String customerName, Long mobile) {
		this.customerName = customerName;
		this.mobile = mobile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String toString() {
		return "Customer Name : " + this.customerName + " , Id :" + this.id;
		
	}
}
