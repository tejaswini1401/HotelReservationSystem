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
        hotelReservationSystem.addHotel("Bridgewood", 350, 50,5);
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
        assertEquals(350, hotels.get(1).getWeekdayRate());
        assertEquals(50, hotels.get(1).getWeekendRate());
        assertEquals(5, hotels.get(1).getRating());

        
        assertEquals("Vedant", hotels.get(2).getName());
        assertEquals(300, hotels.get(2).getWeekdayRate());
        assertEquals(40, hotels.get(2).getWeekendRate());
        assertEquals(2, hotels.get(2).getRating());
       
    }
    
    @Test
    void testFindCheapestBestRatedHotel() {
    	 LocalDate startDate = LocalDate.of(2020, 9,11); 
         LocalDate endDate = LocalDate.of(2020, 9, 12);   

         List<Hotel> bestRatedcheapestHotels = hotelReservationSystem.findCheapestHotel(startDate, endDate);
         
         assertNotNull(bestRatedcheapestHotels);
         assertEquals(1,bestRatedcheapestHotels.size());        
         
         assertEquals("Lakewood",bestRatedcheapestHotels.get(0).getName());
         assertEquals(4,bestRatedcheapestHotels.get(0).getRating());
         assertEquals(300,bestRatedcheapestHotels.get(0).totalRateCalculate(startDate, endDate));        
    }
    
    @Test
    void testFindBestRatedHotel() {
        LocalDate startDate = LocalDate.of(2020, 9,11); 
        LocalDate endDate = LocalDate.of(2020, 9, 12);   

        List<Hotel> bestRatedHotels = hotelReservationSystem.findBestRatedHotel(startDate, endDate);
        
        assertNotNull(bestRatedHotels);
        assertEquals(1,bestRatedHotels.size());        
        
        assertEquals("Bridgewood",bestRatedHotels.get(0).getName());
        assertEquals(5,bestRatedHotels.get(0).getRating());
        assertEquals(400,bestRatedHotels.get(0).totalRateCalculate(startDate, endDate));        
    }    
    
}
