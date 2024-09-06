package com.hotelReservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Hotel> findcheapestHotel(LocalDate startTime, LocalDate endTime , boolean isRewardCustomer) throws InvalidInputException {
		validInput(startTime,endTime,isRewardCustomer);
		List<Hotel> chepestHotel = new ArrayList<>();
		double minRate = Double.MAX_VALUE;
		for(Hotel hotel : hotels) {
			double totalRate = hotel.totalRateCalculate(startTime, endTime ,isRewardCustomer);
			
			if(totalRate < minRate) {
				minRate = totalRate;
				chepestHotel.clear();
				chepestHotel.add(hotel);
			}else if(totalRate == minRate) {
				chepestHotel.add(hotel);
			}
		}
		
		int highestRating = Integer.MIN_VALUE;
		List<Hotel> HighRatedcheapestHotel = new ArrayList<>();
		
		for(Hotel hotel : chepestHotel) {
			if(hotel.getRating() > highestRating) {
				highestRating = hotel.getRating();
				HighRatedcheapestHotel.clear();
				HighRatedcheapestHotel.add(hotel);
			}else if(highestRating == hotel.getRating() ) {
				HighRatedcheapestHotel.add(hotel);
			}
		}
	
		return HighRatedcheapestHotel;
		
	}
	
	public List<Hotel> findBestRatedHotel(LocalDate startTime, LocalDate endTime, boolean isRewardCustomer) {
		
		List<Hotel> bestRatedHotel = new ArrayList<>();
		int highestRating = Integer.MIN_VALUE;
		
		for(Hotel hotel : hotels) {
			if(hotel.getRating() > highestRating) {
				highestRating = hotel.getRating();
				bestRatedHotel.clear();
				bestRatedHotel.add(hotel);
			}else if (hotel.getRating() == highestRating) {
				bestRatedHotel.add(hotel);
			}
		}
		return bestRatedHotel;
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to hotel reservation system");
		
		
	}
}
