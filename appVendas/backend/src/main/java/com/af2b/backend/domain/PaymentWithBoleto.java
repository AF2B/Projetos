package com.af2b.backend.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.af2b.backend.domain.enums.PaymentState;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("paymentWithBoleto")
public class PaymentWithBoleto extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date expirationDate;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date paymentDate;

	public PaymentWithBoleto() {
	}

	public PaymentWithBoleto(Integer id, PaymentState paymentState, Request request, Date expirationDate, Date paymentDate) {
		super(id, paymentState, request);
		this.paymentDate = paymentDate;
		this.expirationDate = expirationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}	
	
}