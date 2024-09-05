package com.hotelReservation;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hotel {
	private String name;
	private double weekdayRate;
	private double weekendRate;
	private double weekdayReward;
	private double weekendReward;
	private int rating;

	public Hotel(String name, double weekdayRate, double weekendRate, double weekdayReward, double weekendReward,
			int rating) {
		super();
		this.name = name;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.weekdayReward = weekdayReward;
		this.weekendReward = weekendReward;
		this.rating = rating;
	}

	public double totalRateCalculate(LocalDate startDate, LocalDate endDate, boolean isRewardCustomer) {
        double totalRate = 0;
        LocalDate date = startDate;

        while (!date.isAfter(endDate)) {
           boolean isWeekEnd = date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
           if(isRewardCustomer) {
        	   totalRate +=  isWeekEnd ? weekendReward : weekdayReward;
           }else {
        	   totalRate += isWeekEnd ? weekendRate : weekdayRate;
           }
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

	public double getWeekdayReward() {
		return weekdayReward;
	}

	public void setWeekdayReward(double weekdayReward) {
		this.weekdayReward = weekdayReward;
	}

	public double getWeekendReward() {
		return weekendReward;
	}

	public void setWeekendReward(double weekendReward) {
		this.weekendReward = weekendReward;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", weekdayRate=" + weekdayRate + ", weekendRate=" + weekendRate
				+ ", weekdayReward=" + weekdayReward + ", weekendReward=" + weekendReward + ", rating=" + rating + "]";
	}
}
