package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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
        hotelReservationSystem.addHotel("Lakewood", 200, 100,4);
        hotelReservationSystem.addHotel("Bridgewood", 250, 50,3);
        hotelReservationSystem.addHotel("Vedant", 300, 40,2);
    }

    @Test
    void testAddHotel() {
        
        List<Hotel> hotels = hotelReservationSystem.getHotel();
        
        assertEquals(3, hotels.size());
        assertEquals("Lakewood", hotels.get(0).getName());
        assertEquals(200, hotels.get(0).getWeekdayRate());
        assertEquals(100, hotels.get(0).getWeekendRate());
        assertEquals(4, hotels.get(0).getRating());

        
        assertEquals("Bridgewood", hotels.get(1).getName());
        assertEquals(250, hotels.get(1).getWeekdayRate());
        assertEquals(50, hotels.get(1).getWeekendRate());
        assertEquals(3, hotels.get(1).getRating());

        
        assertEquals("Vedant", hotels.get(2).getName());
        assertEquals(300, hotels.get(2).getWeekdayRate());
        assertEquals(40, hotels.get(2).getWeekendRate());
        assertEquals(2, hotels.get(2).getRating());
       
    }
    
    @Test
    void testFindCheapestHotel() {
        LocalDate startDate = LocalDate.of(2020, 9,11); 
        LocalDate endDate = LocalDate.of(2020, 9, 12);   

        List<Hotel> cheapestHotels = hotelReservationSystem.findCheapestHotel(startDate, endDate);
        
        assertNotNull(cheapestHotels);

        assertTrue(cheapestHotels.stream().anyMatch(hotel -> hotel.getName().equals("Lakewood")));
        assertTrue(cheapestHotels.stream().anyMatch(hotel -> hotel.getName().equals("Bridgewood")));
        assertFalse(cheapestHotels.stream().anyMatch(hotel -> hotel.getName().equals("Vedant")));

        
        Hotel lakewood = cheapestHotels.stream()
        		.filter(h -> h.getName().equals("Lakewood"))
        		.findFirst().get();
	    assertEquals(300, lakewood.totalRateCalculate(startDate, endDate));
	    
	    Hotel bridgewood = cheapestHotels.stream()
	            .filter(h -> h.getName().equals("Bridgewood"))
	            .findFirst().get();
	    assertEquals(300, bridgewood.totalRateCalculate(startDate, endDate));
	    
    }
}
