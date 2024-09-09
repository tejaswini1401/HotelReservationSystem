package com.hotelReservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HotelReservationSystem {
	
	private List<Hotel> hotels;
    private static final String DATE_REGEX = "\\d{2}[A-Za-z]{3}\\d{4}";
	
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
	
	public void validInput(String startDate, String endDate) throws InvalidInputException {
	    if (startDate == null || endDate == null) {
	        throw new InvalidInputException("Start and end date cannot be null");
	    }

	    if (!Pattern.matches(DATE_REGEX, startDate) || !Pattern.matches(DATE_REGEX, endDate)) {
	        throw new InvalidInputException("Invalid date format. Use format: ddMMMyyyy (e.g., 11Sep2020)");
	    }
	}

	public LocalDate parseDate(String date) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy").withLocale(Locale.ENGLISH);
	    return LocalDate.parse(date, formatter);
	}


    public List<Hotel> findCheapestHotel(String startDateStr, String endDateStr, boolean isRewardCustomer) throws InvalidInputException {
        validInput(startDateStr, endDateStr);

        LocalDate startDate = parseDate(startDateStr);
        LocalDate endDate = parseDate(endDateStr);

        if (startDate.isAfter(endDate)) {
            throw new InvalidInputException("Start date must be before or equal to the end date.");
        }

        double minRate = hotels.stream()
            .mapToDouble(hotel -> hotel.totalRateCalculate(startDate, endDate, isRewardCustomer))
            .min()
            .orElseThrow(() -> new InvalidInputException("No hotel rates found"));

        List<Hotel> cheapestHotels = hotels.stream()
            .filter(hotel -> hotel.totalRateCalculate(startDate, endDate, isRewardCustomer) == minRate)
            .collect(Collectors.toList());

        int maxRating = cheapestHotels.stream()
            .mapToInt(Hotel::getRating)
            .max()
            .orElseThrow(() -> new InvalidInputException("No ratings found"));

        return cheapestHotels.stream()
            .filter(hotel -> hotel.getRating() == maxRating)
            .collect(Collectors.toList());
    }
	public List<Hotel> findBestRatedHotel(LocalDate startDate, LocalDate endDate, boolean isRewardCustomer) throws InvalidInputException{
		
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
