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
        hotelReservationSystem.addHotel("Lakewood", 110, 90,80,80,3);
        hotelReservationSystem.addHotel("Bridgewood", 150, 50,110,50,4);
        hotelReservationSystem.addHotel("Ridgewood", 220, 150,100,40,5);
    }

    @Test
    void testAddHotel() {
        
        List<Hotel> hotels = hotelReservationSystem.getHotel();
        
        assertEquals(3, hotels.size());
        assertEquals("Lakewood", hotels.get(0).getName());
        assertEquals(110, hotels.get(0).getWeekdayRate());
        assertEquals(90, hotels.get(0).getWeekendRate());
        assertEquals(80, hotels.get(0).getWeekdayReward());
        assertEquals(80, hotels.get(0).getWeekendReward());
        assertEquals(3, hotels.get(0).getRating());

        
        assertEquals("Bridgewood", hotels.get(1).getName());
        assertEquals(150, hotels.get(1).getWeekdayRate());
        assertEquals(50, hotels.get(1).getWeekendRate());
        assertEquals(110, hotels.get(1).getWeekdayReward());
        assertEquals(50, hotels.get(1).getWeekendReward());
        assertEquals(4, hotels.get(1).getRating());

        
        assertEquals("Ridgewood", hotels.get(2).getName());
        assertEquals(220, hotels.get(2).getWeekdayRate());
        assertEquals(150, hotels.get(2).getWeekendRate());
        assertEquals(100, hotels.get(2).getWeekdayReward());
        assertEquals(40, hotels.get(2).getWeekendReward());
        assertEquals(5, hotels.get(2).getRating());
       
    }
    
    @Test
    void testFindCheapestBestRatedHotel() {
    	 LocalDate startDate = LocalDate.of(2020, 9,11); 
         LocalDate endDate = LocalDate.of(2020, 9, 12);   

         List<Hotel> bestRatedcheapestHotels = hotelReservationSystem.findCheapestHotel(startDate, endDate, false);
         
         assertNotNull(bestRatedcheapestHotels);
         assertEquals(1,bestRatedcheapestHotels.size());        
         
         assertEquals("Bridgewood",bestRatedcheapestHotels.get(0).getName());
         assertEquals(4,bestRatedcheapestHotels.get(0).getRating());
         assertEquals(200,bestRatedcheapestHotels.get(0).totalRateCalculate(startDate, endDate, false));        
    }
    
    @Test
    void testFindBestRatedHotel() {
        LocalDate startDate = LocalDate.of(2020, 9,11); 
        LocalDate endDate = LocalDate.of(2020, 9, 12);   

        List<Hotel> bestRatedHotels = hotelReservationSystem.findBestRatedHotel(startDate, endDate,false);
        
        assertNotNull(bestRatedHotels);
        assertEquals(1,bestRatedHotels.size());        
        
        assertEquals("Ridgewood",bestRatedHotels.get(0).getName());
        assertEquals(5,bestRatedHotels.get(0).getRating());
        assertEquals(370,bestRatedHotels.get(0).totalRateCalculate(startDate, endDate,false));        
    }    
    
}
