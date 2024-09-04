package com.hotelReservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {
	
	private List<Hotel> hotels;
	
	public HotelReservationSystem() {
		this.hotels = new ArrayList<>();
	}
	
	public void addHotel(String name, double customerRate) {
		Hotel newHotel = new Hotel(name, customerRate);
		hotels.add(newHotel);
	}
	
	public List<Hotel> getHotel(){
		return hotels;
	}
	
	public Hotel findCheapestHotel(LocalDate startTime, LocalDate endTime) {
		Hotel cheapestHotel = null;
		double minRate = Double.MAX_VALUE;
		
		for(Hotel hotel : hotels) {
			double totalRate = hotel.totalRateCalculate(startTime, endTime);
			if(totalRate < minRate) {
				minRate = totalRate;
				cheapestHotel = hotel;
			}
		}
		return cheapestHotel;
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to hotel reservation system");
		
		
	}
}
