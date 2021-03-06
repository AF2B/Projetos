package com.af2b.backend.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemRequestPK id = new ItemRequestPK();
	
	private Double descount;
	private Integer quantity;
	private Double price;
	
	public ItemRequest() {
	}

	public ItemRequest(Request request, Product product, Double descount, Integer quantity, Double price) {
		super();
		id.setRequest(request);
		id.setProduct(product);
		this.descount = descount;
		this.quantity = quantity;
		this.price = price;
	}

	public double getSubTotal() {
		return (price - descount) * quantity;
	}
	
	@JsonIgnore
	public Request getRequest() {
		return id.getRequest();
	}
	
	public void setRequest(Request request) {
		id.setRequest(request);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public ItemRequestPK getId() {
		return id;
	}

	public void setId(ItemRequestPK id) {
		this.id = id;
	}

	public Double getDescount() {
		return descount;
	}

	public void setDescount(Double descount) {
		this.descount = descount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemRequest other = (ItemRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append(getProduct().getName());
		builder.append(", Qte: ");
		builder.append(getQuantity());
		builder.append(", Pre??o unit??rio: ");
		builder.append(nf.format(getPrice()));
		builder.append(", Subtotal: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n");
		return builder.toString();
	}
}