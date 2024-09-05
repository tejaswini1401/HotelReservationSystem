package com.hotelReservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {
	
	private List<Hotel> hotels;
	
	public HotelReservationSystem() {
		this.hotels = new ArrayList<>();
	}
	
	public void addHotel(String name, double weekdayRate, double weekendRate,int rating) {
        Hotel hotel = new Hotel(name, weekdayRate, weekendRate, rating);
        hotels.add(hotel);
        System.out.println("Hotel added successfully.");
    }
	
	public List<Hotel> getHotel(){
		return hotels;
	}
	
	public List<Hotel> findCheapestHotel(LocalDate startTime, LocalDate endTime) {
		List<Hotel> cheapestHotel = new ArrayList<>();
		double minRate = Double.MAX_VALUE;
		
		for(Hotel hotel : hotels) {
			double totalRate = hotel.totalRateCalculate(startTime, endTime);
			if(totalRate < minRate) {
				minRate = totalRate;
				cheapestHotel.clear();
				cheapestHotel.add(hotel);
			}else if(totalRate == minRate) {
				cheapestHotel.add(hotel);
			}
		}
		
		List<Hotel> bestRatedCheapestHotel = new ArrayList<>();
		int highestRating = Integer.MIN_VALUE;
		
		for(Hotel hotel : cheapestHotel) {
			if(hotel.getRating() > highestRating) {
				highestRating = hotel.getRating();
				bestRatedCheapestHotel.clear();
				bestRatedCheapestHotel.add(hotel);
			}else if (hotel.getRating() == highestRating) {
				bestRatedCheapestHotel.add(hotel);
			}
		}
		return bestRatedCheapestHotel;
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to hotel reservation system");
		
		
	}
}
