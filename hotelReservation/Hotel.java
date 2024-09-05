package com.hotelReservation;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hotel {
	private String name;
	private double weekdayRate;
	private double weekendRate;
	private int rating;
	
	public Hotel(String name, double weekdayRate, double weekendRate, int rating) {
		super();
		this.name = name;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.rating = rating;
	}
	
	
	public double totalRateCalculate(LocalDate startDate, LocalDate endDate) {
        double totalRate = 0;
        LocalDate date = startDate;

        while (!date.isAfter(endDate)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                totalRate += weekendRate;
            } else {
                totalRate += weekdayRate;
            }
            date = date.plusDays(1);
        }
        return totalRate;
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getWeekdayRate() {
		return weekdayRate;
	}


	public void setWeekdayRate(double weekdayRate) {
		this.weekdayRate = weekdayRate;
	}


	public double getWeekendRate() {
		return weekendRate;
	}


	public void setWeekendRate(double weekendRate) {
		this.weekendRate = weekendRate;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Hotel [name=" + name + ", weekdayRate=" + weekdayRate + ", weekendRate=" + weekendRate + ", rating="
				+ rating + "]";
	}
}
