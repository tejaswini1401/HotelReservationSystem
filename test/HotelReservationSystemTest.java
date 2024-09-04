package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hotelReservation.Hotel;
import com.hotelReservation.HotelReservationSystem;

class HotelReservationSystemTest {
	
	HotelReservationSystem hotelReservationSystem;
	
	@BeforeEach
	void setUp() {
		hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel("Vedant",100.00,90);
		hotelReservationSystem.addHotel("Vithhal",200.00,100);
		hotelReservationSystem.addHotel("Atithi",300.00,250);
	}

	@Test
	void testAddHotel() {
		
		List<Hotel> hotels = hotelReservationSystem.getHotel();
		
		assertEquals(3, hotels.size());
		assertEquals("Vedant", hotels.get(0).getName());
		assertEquals(100.00, hotels.get(0).getWeekdayRate());
		assertEquals(90, hotels.get(0).getWeekendRate());
		
		assertEquals("Vithhal", hotels.get(1).getName());
		assertEquals(200.00, hotels.get(1).getWeekdayRate());
		assertEquals(100, hotels.get(1).getWeekendRate());
		
		assertEquals("Atithi", hotels.get(2).getName());
		assertEquals(300.00, hotels.get(2).getWeekdayRate());
		assertEquals(250, hotels.get(2).getWeekendRate());
		
	}
	
	@Test
	void testFindCheapestHotel() {
	    LocalDate startDate = LocalDate.of(2024, 9, 7);
	    LocalDate endDate = LocalDate.of(2024, 9, 8);
	    
	    Hotel cheapestHotel = hotelReservationSystem.findCheapestHotel(startDate, endDate);
	    
	    assertNotNull(cheapestHotel);
	    assertEquals("Vedant", cheapestHotel.getName());
	    
	    
	    assertEquals(180, cheapestHotel.totalRateCalculate(startDate, endDate));
	}
}
