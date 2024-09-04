package com.test;

import static org.junit.jupiter.api.Assertions.*;

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
	}

	@Test
	void testAddHotel() {
		hotelReservationSystem.addHotel("Vedant",100.00);
		hotelReservationSystem.addHotel("Vithhal",200.00);
		
		List<Hotel> hotels = hotelReservationSystem.getHotel();
		
		assertEquals(2, hotels.size());
		assertEquals("Vedant", hotels.get(0).getName());
		assertEquals(100.00, hotels.get(0).getCustomerRate());
		
		assertEquals("Vithhal", hotels.get(1).getName());
		assertEquals(200.00, hotels.get(1).getCustomerRate());
		
	}

}
