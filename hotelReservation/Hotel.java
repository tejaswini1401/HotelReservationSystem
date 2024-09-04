package com.hotelReservation;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Hotel {
	private String name;
	private double customerRate;
	
	public Hotel(String name, double customerRate) {
		super();
		this.name = name;
		this.customerRate = customerRate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCustomerRate() {
		return customerRate;
	}
	public void setCustomerRate(double customerRate) {
		this.customerRate = customerRate;
	}
	
	public double totalRateCalculate(LocalDate startTime, LocalDate endTime) {
		long days = ChronoUnit.DAYS.between(startTime, endTime)+1;
		return days*customerRate;
	}
	
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", customerRate=" + customerRate + "]";
	}	
}
