package com..reservation;

import com.reservation.hotels.DefaultHotels;
import com.reservation.hotels.Hotels;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReservationSystemTest {
    @Test
    public void shouldReserveCheapestRoomForOneRegularWeekday(){
        Hotels hotels = new DefaultHotels().hotels();
        ReservationSystem reservationSystem = new ReservationSystem(newArrayList("Regular: 20Mar2020(fri)"), hotels);
        assertThat(reservationSystem.reservationResults(), is("Lakewood"));
    }

    @Test
    public void shouldReserveCheapestRoomForOneRegularWeekendDay(){
        Hotels hotels = new DefaultHotels().hotels();
        ReservationSystem reservationSystem = new ReservationSystem(newArrayList("Regular: 21Mar2020(sat)"), hotels);
        assertThat(reservationSystem.reservationResults(), is("Bridgewood"));
    }

    @Test
    public void shouldReserveCheapestRoomForRegularForOneWeekdayAndOneWeekendDay(){
        Hotels hotels = new DefaultHotels().hotels();
        ReservationSystem reservationSystem = new ReservationSystem(newArrayList("Regular: 20Mar2020(fri) 21Mar2020(sat)"), hotels);
        assertThat(reservationSystem.reservationResults(), is("Lakewood"));
    }

    @Test
    public void shouldReserveCheapestRoomForRewardsForOneWeekdayAndOneWeekendDay(){
        Hotels hotels = new DefaultHotels().hotels();
        ReservationSystem reservationSystem = new ReservationSystem(newArrayList("Rewards: 20Mar2020(fri) 21Mar2020(sat)"), hotels);
        assertThat(reservationSystem.reservationResults(), is("Ridgewood"));
    }
}
