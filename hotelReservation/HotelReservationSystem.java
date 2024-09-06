package com.hotelReservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservationSystem {
	
	private List<Hotel> hotels;
	
	public HotelReservationSystem() {
		this.hotels = new ArrayList<>();
	}
	
	public void addHotel(String name, double weekdayRate, double weekendRate,double weekdayReward, double weekendReward,int rating) {
        Hotel hotel = new Hotel(name, weekdayRate, weekendRate,weekdayReward, weekendReward, rating);
        hotels.add(hotel);
        System.out.println("Hotel added successfully.");
    }
	
	public List<Hotel> getHotel(){
		return hotels;
	}
	
	public void validInput(LocalDate startTime, LocalDate endTime, boolean isRewardCustomer) throws  InvalidInputException{
		if(startTime == null || endTime == null) {
			throw new InvalidInputException("Start and end date caanot be null");
		}
		if(startTime.isAfter(endTime)) {
			throw new InvalidInputException("Start date must be before or equal to the end date.");
		}
		if(!isRewardCustomer && isRewardCustomer) {
			throw new InvalidInputException("Invalid customer type");
		}
	}
	
	public List<Hotel> findcheapestHotel(LocalDate startDate, LocalDate endDate , boolean isRewardCustomer) throws InvalidInputException {
		validInput(startDate,endDate,isRewardCustomer);	        
	        double minRate = hotels.stream()
	                .mapToDouble(hotel -> hotel.totalRateCalculate(startDate, endDate, isRewardCustomer))
	                .min().orElseThrow();

	        List<Hotel> cheapestHotels = hotels.stream()
	                .filter(hotel -> hotel.totalRateCalculate(startDate, endDate, isRewardCustomer) == minRate)
	                .collect(Collectors.toList());

	        int maxRating = cheapestHotels.stream()
	                .mapToInt(Hotel::getRating)
	                .max().orElseThrow();

	        return cheapestHotels.stream()
	                .filter(hotel -> hotel.getRating() == maxRating)
	                .collect(Collectors.toList());
		
	}
	
	public List<Hotel> findBestRatedHotel(LocalDate startDate, LocalDate endDate, boolean isRewardCustomer) throws InvalidInputException{
		
		 validInput(startDate, endDate, isRewardCustomer);

	        int highestRating = hotels.stream()
	                .mapToInt(Hotel::getRating)
	                .max().orElseThrow();

	        return hotels.stream()
	                .filter(hotel -> hotel.getRating() == highestRating)
	                .collect(Collectors.toList());
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to hotel reservation system");
		
		
	}
}
