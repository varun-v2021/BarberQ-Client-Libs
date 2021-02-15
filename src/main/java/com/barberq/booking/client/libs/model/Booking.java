package com.barberq.booking.client.libs.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "`Booking`")
@ApiModel("All details about the bookings here")
@JsonSerialize
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private Long id;

	@Column
	private Timestamp date;
	
	@JsonManagedReference
	@OneToMany(mappedBy="booking", cascade = CascadeType.ALL )
	private List<SalonServ> services;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@JsonManagedReference
	@OneToOne(mappedBy="booking", cascade = CascadeType.ALL)
	private Token token;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public List<SalonServ> getServices() {
		return services;
	}

	public void setServices(List<SalonServ> services) {
		this.services = services;
		for(SalonServ service : services) {
			service.setBooking(this);
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
}
