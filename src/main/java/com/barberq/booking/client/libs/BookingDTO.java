package com.barberq.booking.client.libs;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.barberq.booking.client.libs.model.Customer;
import com.barberq.booking.client.libs.model.SalonServ;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;

@ApiModel("Booking DTO representation")
@JsonSerialize
public class BookingDTO {

	private Timestamp date;
	private List<SalonServ> services;
	private Customer customer;

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
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
