package com.hotelReservation;

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

	public static void main(String[] args) {
		
		System.out.println("Welcome to hotel reservation system");
		
		
	}
}
