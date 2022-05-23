package com.af2b.backend.domain;

import javax.persistence.Entity;

import com.af2b.backend.domain.enums.PaymentState;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("paymentWithCard")
public class PaymentWithCard extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer numberOfParcels;
	
	public PaymentWithCard() {
	}

	public PaymentWithCard(Integer id, PaymentState paymentState, Request request, Integer numberOfParcels) {
		super(id, paymentState, request);
		this.numberOfParcels = numberOfParcels;
	}

	public Integer getNumberOfParcels() {
		return numberOfParcels;
	}

	public void setNumberOfParcels(Integer numberOfParcels) {
		this.numberOfParcels = numberOfParcels;
	}
}
