package es.jsomoza.embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	private Integer number;
	
	public Address () {
		
	}
	
	public Address(String street, Integer number) {
		this.street = street;
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + "]";
	}
	
	
}