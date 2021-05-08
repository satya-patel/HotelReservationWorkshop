package com.reservation;

import com.reservation.hotels.DefaultHotels;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class HotelManagementMain {
    public static void main(String... args) throws IOException {
        System.out.println("Welcome to hotel management!");
        
        String fileLocation = "input/sampleInput.txt";
        List<String> lines = Files.readLines(new File(fileLocation), Charsets.UTF_8);

        ReservationSystem reservationSystem = new ReservationSystem(lines, new DefaultHotels().hotels());
        System.out.println(reservationSystem.reservationResults());
    }
}
